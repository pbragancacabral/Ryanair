package com.pbragancacabral.ryanair.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Roster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private byte pattern;
    @OneToMany(mappedBy = "rosterPattern", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH})
    private List<Crew> crews = new ArrayList();

    public Roster() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte getPattern() {
        return pattern;
    }

    public void setPattern(byte pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "Roster{" +
                "id=" + id +
                ", pattern=" + pattern +
                '}';
    }
}