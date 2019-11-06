package com.pbragancacabral.ryanair.dao;

import com.pbragancacabral.ryanair.entity.Roster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RosterRepository extends JpaRepository<Roster, Long> {
}
