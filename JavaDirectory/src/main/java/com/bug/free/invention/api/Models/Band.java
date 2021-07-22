package com.bug.free.invention.api.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Objects;

@Table(value = "band")
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(value = "bandID")
    Integer bandID;
    @Column(value = "bandName")
    private String bandName;
    @Column(value = "bandLevel")
    Integer bandLevel;
    @Column(value = "bandTraining")
    private String bandTraining;
    @Column(value = "bandCompetencies")
    private String bandCompetencies;
    @Column(value = "bandResponsibilites")
    String bandResponsibilites;

//    public Band() {}

    public Band(Integer bandID, String bandName, Integer bandLevel, String bandTraining, String bandCompetencies, String bandResponsibilites) {
        this.bandID = bandID;
        this.bandName = bandName;
        this.bandLevel = bandLevel;
        this.bandTraining = bandTraining;
        this.bandCompetencies = bandCompetencies;
        this.bandResponsibilites = bandResponsibilites;
    }

    public Integer getBandID() {
        return bandID;
    }

    public void setBandID(Integer bandID) {
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
    public void setBandLevel(Integer bandLevel) {
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

    public void setBandResponsibilities(String bandResponsibilites) {
        this.bandResponsibilites = bandResponsibilites;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Band band = (Band) o;
        return bandID == band.bandID && bandLevel == band.bandLevel && Objects.equals(bandName, band.bandName) && Objects.equals(bandTraining, band.bandTraining) && Objects.equals(bandCompetencies, band.bandCompetencies) && Objects.equals(bandResponsibilites, band.bandResponsibilites);
    }
    @Override
    public int hashCode() {
        return Objects.hash(bandID, bandName, bandLevel, bandTraining, bandCompetencies, bandResponsibilites);
    }
    @Override
    public String toString() {
        return "Band{" +
                "bandId=" + bandID +
                ", bandName='" + bandName + '\'' +
                ", bandLevel=" + bandLevel +
                ", bandTraining='" + bandTraining + '\'' +
                ", bandCompetencies='" + bandCompetencies + '\'' +
                ", bandResponsibilities='" + bandResponsibilites + '\'' +
                '}';
    }
}