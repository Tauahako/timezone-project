package com.tahitinumerique.tz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimezoneDTO {
    private Long id;
    private String Label;
    private String companyName;
    private String timezoneValue;
}
