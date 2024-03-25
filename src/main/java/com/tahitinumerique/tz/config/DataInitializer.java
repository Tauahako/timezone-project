package com.tahitinumerique.tz.config;

import com.tahitinumerique.tz.entity.Timezone;
import com.tahitinumerique.tz.repository.TimezoneRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

    @Autowired
    TimezoneRepo timezoneRepo;

    @Override
    public void run(String... args) throws Exception {
        Timezone timezone1 = new Timezone();
        timezone1.setId(1L);
        timezone1.setLabel("France");
        timezone1.setCompanyName("Tech Way");
        timezone1.setTimezoneValue("Europe/Paris");

        Timezone timezone2 = new Timezone();
        timezone2.setId(2L);
        timezone2.setLabel("Tahiti");
        timezone2.setCompanyName("Tahiti Numérique");
        timezone2.setTimezoneValue("Pacific/Tahiti");

        Timezone timezone3 = new Timezone();
        timezone3.setId(3L);
        timezone3.setLabel("Alaska");
        timezone3.setCompanyName("Fake Company");
        timezone3.setTimezoneValue("America/Juneau");

        timezoneRepo.save(timezone1);
        log.info(String.format("Timezone %s has been added", timezone1.getLabel()));
        timezoneRepo.save(timezone2);
        log.info(String.format("Timezone %s has been added", timezone2.getLabel()));
        timezoneRepo.save(timezone3);
        log.info(String.format("Timezone %s has been added", timezone3.getLabel()));
    }
}
