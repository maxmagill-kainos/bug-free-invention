package com.bug.free.invention.api.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "band")
public class band {
    @OneToOne(mappedBy = "bandID")
    @Id int bandID;
    private String bandName;
    private int bandLevel;
    private String bandTraining;
    private String bandCompetencies;
    private String bandResponsibilites;

    public int getBandID() {
        return bandID;
    }

    public void setBandID(int bandID) {
        this.bandID = bandID;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public int getBandLevel() {
        return bandLevel;
    }

    public void setBandLevel(int bandLevel) {
        this.bandLevel = bandLevel;
    }

    public String getBandTraining() {
        return bandTraining;
    }

    public void setBandTraining(String bandTraining) {
        this.bandTraining = bandTraining;
    }

    public String getBandCompetencies() {
        return bandCompetencies;
    }

    public void setBandCompetencies(String bandCompetencies) {
        this.bandCompetencies = bandCompetencies;
    }

    public String getBandResponsibilites() {
        return bandResponsibilites;
    }

    public void setBandResponsibilites(String bandResponsibilites) {
        this.bandResponsibilites = bandResponsibilites;
    }
}
