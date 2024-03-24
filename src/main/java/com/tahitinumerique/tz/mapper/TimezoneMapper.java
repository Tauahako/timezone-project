package com.tahitinumerique.tz.mapper;

import com.tahitinumerique.tz.dto.TimezoneDTO;
import com.tahitinumerique.tz.entity.Timezone;

public class TimezoneMapper {

    public static TimezoneDTO toDTO(Timezone timezone) {
        return new TimezoneDTO(
                timezone.getId(),
                timezone.getLabel(),
                timezone.getCompanyName(),
                timezone.getTimezoneValue()
        );
    }

    public static Timezone toModel(TimezoneDTO timezoneDTO) {
        return new Timezone(
                timezoneDTO.getId(),
                timezoneDTO.getLabel(),
                timezoneDTO.getCompanyName(),
                timezoneDTO.getTimezoneValue()
        );
    }

    public static void updateModel(TimezoneDTO update, Timezone modelToUpdate) {
        modelToUpdate.setLabel(update.getLabel());
        modelToUpdate.setCompanyName(update.getCompanyName());
        modelToUpdate.setTimezoneValue(update.getTimezoneValue());
    }

}
