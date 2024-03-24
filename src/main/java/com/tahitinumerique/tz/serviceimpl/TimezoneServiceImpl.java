package com.tahitinumerique.tz.serviceimpl;

import com.tahitinumerique.tz.entity.Timezone;
import com.tahitinumerique.tz.exception.NotFoundProblem;
import com.tahitinumerique.tz.repository.TimezoneRepo;
import com.tahitinumerique.tz.service.TimezoneService;
import com.tahitinumerique.tz.util.ConstantMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TimezoneServiceImpl implements TimezoneService {

    TimezoneRepo timezoneRepo;

    @Override
    public Timezone createTimezone(Timezone timezone) {
        return timezoneRepo.save(timezone);
    }

    @Override
    public Timezone getTimezone(Long timezoneId) {
        return timezoneRepo.findById(timezoneId)
                .orElseThrow(() -> new NotFoundProblem(ConstantMessages.TIMEZONE, timezoneId));
    }

    @Override
    public List<Timezone> getAllTimezones() {
        return timezoneRepo.findAll();
    }

    @Override
    public void updateTimezone(Timezone timezone) {
        timezoneRepo.save(timezone);
    }

    @Override
    public void deleteTimezone(Long timezoneId) {
        Timezone toDelete = getTimezone(timezoneId);
        timezoneRepo.delete(toDelete);
    }
}
