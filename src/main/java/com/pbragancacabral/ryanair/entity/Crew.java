package com.pbragancacabral.ryanair.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Crew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH})

    @NotNull(message = "is required")
    private Base base;

    @NotBlank(message = "is required")
    private String crewcode;

    @NotNull(message = "is required")
    private Integer rosterPattern;

    @Email(message = "is required")
    @NotBlank(message = "is required")
    private String email;

    @NotBlank(message = "is required")
    private String password;

    public Crew() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getRosterPattern() {
        return rosterPattern;
    }

    public void setRosterPattern(Integer rosterPattern) {
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

    @Override
    public String toString() {
        return "Crew{" +
                "id=" + id +
                ", base=" + base +
                ", crewcode='" + crewcode + '\'' +
                ", rosterPattern=" + rosterPattern +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}