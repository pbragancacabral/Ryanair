package com.pbragancacabral.ryanair.dao;

import com.pbragancacabral.ryanair.entity.Crew;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrewRepository extends JpaRepository<Crew, Long> {
}