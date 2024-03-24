package com.tahitinumerique.tz.service;

import com.tahitinumerique.tz.entity.Timezone;

import java.util.List;

public interface TimezoneService {
    Timezone createTimezone(Timezone timezone);

    Timezone getTimezone(Long timezoneId);

    List<Timezone> getAllTimezones();

    void updateTimezone(Timezone timezone);

    void deleteTimezone(Long timezoneId);
}
