package com.pbragancacabral.ryanair.dao;

import com.pbragancacabral.ryanair.entity.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseRepository extends JpaRepository<Base, Long> {
    public List<Base> findAllByOrderByIATACodeAsc();
}