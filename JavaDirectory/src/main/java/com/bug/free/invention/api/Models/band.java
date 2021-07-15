package com.bug.free.invention.api.Models;

import javax.persistence.*;


import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Objects;

@Entity
@Table(name = "band")
public class band {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bandID")
    int bandID;
    @Column(name = "bandName")
    String bandName;
    @Column(name = "bandLevel")
    int bandLevel;
    @Column(name = "bandTraining")
    String bandTraining;
    @Column(name = "bandCompetencies")
    String bandCompetencies;
    @Column(name = "bandResponsibilites")
    String bandResponsibilities;

    public band() {}

//    public Band(int bandID, String bandName, int bandLevel, String bandTraining, String bandCompetencies, String bandResponsibilities) {
//        this.bandID = bandID;
//        this.bandName = bandName;
//        this.bandLevel = bandLevel;
//        this.bandTraining = bandTraining;
//        this.bandCompetencies = bandCompetencies;
//        this.bandResponsibilities = bandResponsibilities;
//    }

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

    public String getBandResponsibilities() {
        return bandResponsibilities;
    }

    public void setBandResponsibilities(String bandResponsibilities) {
        this.bandResponsibilities = bandResponsibilities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        band band = (com.bug.free.invention.api.Models.band) o;
        return bandID == band.bandID && bandLevel == band.bandLevel && Objects.equals(bandName, band.bandName) && Objects.equals(bandTraining, band.bandTraining) && Objects.equals(bandCompetencies, band.bandCompetencies) && Objects.equals(bandResponsibilities, band.bandResponsibilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bandID, bandName, bandLevel, bandTraining, bandCompetencies, bandResponsibilities);
    }

    @Override
    public String toString() {
        return "Band{" +
                "bandId=" + bandID +
                ", bandName='" + bandName + '\'' +
                ", bandLevel=" + bandLevel +
                ", bandTraining='" + bandTraining + '\'' +
                ", bandCompetencies='" + bandCompetencies + '\'' +
                ", bandResponsibilities='" + bandResponsibilities + '\'' +
                '}';
    }
}
