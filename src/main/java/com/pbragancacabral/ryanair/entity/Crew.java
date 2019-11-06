package com.pbragancacabral.ryanair.entity;

import javax.persistence.*;

@Entity
public class Crew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH})
    private Base base;
    private String crewcode;
    private int rosterPattern;
    private String email;
    private String password;

    public Crew() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public String getCrewcode() {
        return crewcode;
    }

    public void setCrewcode(String crewcode) {
        this.crewcode = crewcode;
    }

    public int getRosterPattern() {
        return rosterPattern;
    }

    public void setRosterPattern(int rosterPattern) {
        this.rosterPattern = rosterPattern;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}