package com.tahitinumerique.tz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "timezone")
public class Timezone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "label")
    private String Label;

    @Column(name = "company_name")
    private String CompanyName;

    @Column(name = "timezone_id")
    private String timezoneValue;  // Timezone identifier (ex: "Europe/Paris")
}
