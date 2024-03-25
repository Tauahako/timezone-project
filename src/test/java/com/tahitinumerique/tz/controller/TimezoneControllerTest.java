package com.tahitinumerique.tz.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tahitinumerique.tz.dto.TimezoneDTO;
import com.tahitinumerique.tz.entity.Timezone;
import com.tahitinumerique.tz.mapper.TimezoneMapper;
import com.tahitinumerique.tz.service.TimezoneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@WebMvcTest
@ContextConfiguration(classes = {TimezoneController.class})
public class TimezoneControllerTest {
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private TimezoneService timezoneService;
    private Timezone timezone;
    private TimezoneDTO timezoneDTO;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();

        timezone = new Timezone(
                1L,
                "Tahiti",
                "Tahiti Numérique",
                "Pacific/Tahiti"
        );
        timezoneDTO = new TimezoneDTO(
                1L,
                "Tahiti",
                "Tahiti Numérique",
                "Pacific/Tahiti"
        );
    }

    @Test
    void testCreateTimezone() throws Exception {
        when(timezoneService.getTimezone(anyLong())).thenReturn(timezone);
        when(timezoneService.createTimezone(any())).thenReturn(timezone);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/timezones")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(timezoneDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void testGetTimezoneById() throws Exception {
        when(timezoneService.getTimezone(anyLong())).thenReturn(timezone);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/timezones/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testUpdateTimezone() throws Exception {
        mockStatic(TimezoneMapper.class);

        when(timezoneService.getTimezone(anyLong())).thenReturn(timezone);
        doNothing().when(TimezoneMapper.class);
        TimezoneMapper.updateModel(any(), any());
        doNothing().when(timezoneService).updateTimezone(timezone);

        TimezoneDTO update = new TimezoneDTO();
        update.setCompanyName("My Label");

        mockMvc.perform(MockMvcRequestBuilders.put("/api/timezones/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(update)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDeleteTimezone() throws Exception {
        doNothing().when(timezoneService).deleteTimezone(anyLong());

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/timezones/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
