package com.pbragancacabral.ryanair.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String IATACode;
    @OneToMany(mappedBy = "base", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH})
    private List<Crew> crews = new ArrayList<>();

    public Base() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIATACode() {
        return IATACode;
    }

    public void setIATACode(String IATACode) {
        this.IATACode = IATACode;
    }

    public List<Crew> getCrews() {
        return crews;
    }

    public void setCrews(List<Crew> crews) {
        this.crews = crews;
    }

    @Override
    public String toString() {
        return "Base{" +
                "id=" + id +
                ", IATACode='" + IATACode + '\'' +
                ", crews=" + crews +
                '}';
    }
}