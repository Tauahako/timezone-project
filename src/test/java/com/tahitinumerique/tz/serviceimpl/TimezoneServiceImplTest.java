package com.tahitinumerique.tz.serviceimpl;

import com.tahitinumerique.tz.entity.Timezone;
import com.tahitinumerique.tz.exception.NotFoundProblem;
import com.tahitinumerique.tz.repository.TimezoneRepo;
import com.tahitinumerique.tz.service.TimezoneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest
@ActiveProfiles("test")
@ContextConfiguration(classes = {TimezoneServiceImpl.class})
public class TimezoneServiceImplTest {

    @MockBean
    private TimezoneRepo timezoneRepo;

    @Autowired
    private TimezoneService timezoneService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTimezone() {
        Timezone timezone = new Timezone(1L, "Label", "Company", "Europe/Paris");
        when(timezoneRepo.save(timezone)).thenReturn(timezone);

        Timezone result = timezoneService.createTimezone(timezone);
        assertNotNull(result);
        assertEquals(timezone, result);
    }

    @Test
    public void testGetTimezone_Exists() {
        Timezone timezone = new Timezone(1L, "Label", "Company", "Europe/Paris");
        when(timezoneRepo.findById(1L)).thenReturn(Optional.of(timezone));

        Timezone result = timezoneService.getTimezone(1L);
        assertNotNull(result);
        assertEquals(timezone, result);
    }

    @Test
    public void testGetTimezone_NotFound() {
        when(timezoneRepo.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundProblem.class, () -> timezoneService.getTimezone(1L));
    }

    @Test
    public void testGetAllTimezones() {
        List<Timezone> timezones = new ArrayList<>();
        timezones.add(new Timezone(1L, "Label 1", "Company 1", "Europe/Paris"));
        timezones.add(new Timezone(2L, "Label 2", "Company 2", "America/New_York"));
        when(timezoneRepo.findAll()).thenReturn(timezones);

        List<Timezone> result = timezoneService.getAllTimezones();
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testUpdateTimezone() {
        Timezone timezone = new Timezone(1L, "Label", "Company", "Europe/Paris");
        when(timezoneRepo.save(timezone)).thenReturn(timezone);

        assertDoesNotThrow(() -> timezoneService.updateTimezone(timezone));
    }

    @Test
    public void testDeleteTimezone() {
        Timezone timezone = new Timezone(1L, "Label", "Company", "Europe/Paris");
        when(timezoneRepo.findById(1L)).thenReturn(Optional.of(timezone));

        assertDoesNotThrow(() -> timezoneService.deleteTimezone(1L));
    }
}
