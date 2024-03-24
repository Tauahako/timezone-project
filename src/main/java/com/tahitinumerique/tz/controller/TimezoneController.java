package com.tahitinumerique.tz.controller;


import com.tahitinumerique.tz.dto.TimezoneDTO;
import com.tahitinumerique.tz.entity.Timezone;
import com.tahitinumerique.tz.mapper.TimezoneMapper;
import com.tahitinumerique.tz.service.TimezoneService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/timezones")
@Slf4j
public class TimezoneController {
    TimezoneService timezoneService;

    @PostMapping
    public ResponseEntity<TimezoneDTO> createTimezone(@RequestBody TimezoneDTO timezoneDTO) {
        Timezone timezone = TimezoneMapper.toModel(timezoneDTO);
        timezone = timezoneService.createTimezone(timezone);
        log.info("Timezone added successfully !");
        return ResponseEntity.status(HttpStatus.CREATED).body(TimezoneMapper.toDTO(timezone));
    }

    @GetMapping("{id}")
    public ResponseEntity<TimezoneDTO> getTimezoneById(@PathVariable("id") Long timezoneId) {
        Timezone timezone = timezoneService.getTimezone(timezoneId);
        log.info("Timezone fetched successfully !");
        return ResponseEntity.status(HttpStatus.OK).body(TimezoneMapper.toDTO(timezone));
    }

    @GetMapping
    public ResponseEntity<List<TimezoneDTO>> getAllTimezones() {
        List<Timezone> timezones = timezoneService.getAllTimezones();
        List<TimezoneDTO> timezoneDTOS = timezones.stream()
                .map(TimezoneMapper::toDTO)
                .collect(Collectors.toList());
        log.info("Timezone list fetched successfully !");
        return ResponseEntity.status(HttpStatus.OK).body(timezoneDTOS);
    }

    @PutMapping("{id}")
    public ResponseEntity<TimezoneDTO> updateTimezone(
            @PathVariable("id") Long timezoneId,
            @RequestBody TimezoneDTO timezoneUpdateDTO) {
        Timezone timezone = timezoneService.getTimezone(timezoneId);
        TimezoneMapper.updateModel(timezoneUpdateDTO, timezone);
        timezoneService.updateTimezone(timezone);
        log.info("Timezone updated successfully !");
        return ResponseEntity.status(HttpStatus.OK).body(TimezoneMapper.toDTO(timezone));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTimezone(@PathVariable("id") Long timezoneId) {
        timezoneService.deleteTimezone(timezoneId);
        return ResponseEntity.status(HttpStatus.OK).body("Timezone successfully deleted !");
    }
}
