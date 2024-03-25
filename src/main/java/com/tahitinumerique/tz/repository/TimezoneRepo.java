package com.tahitinumerique.tz.repository;

import com.tahitinumerique.tz.entity.Timezone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimezoneRepo extends JpaRepository<Timezone, Long> {
}
