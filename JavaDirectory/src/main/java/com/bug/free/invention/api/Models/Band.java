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
    int bandID;
    @Column(value = "bandName")
    String bandName;
    @Column(value = "bandLevel")
    int bandLevel;
    @Column(value = "bandTraining")
    String bandTraining;
    @Column(value = "bandCompetencies")
    String bandCompetencies;
    @Column(value = "bandResponsibilites")
    String bandResponsibilites;
    public Band() {}
    public Band(int bandID, String bandName, int bandLevel, String bandTraining, String bandCompetencies, String bandResponsibilites) {
        this.bandID = bandID;
        this.bandName = bandName;
        this.bandLevel = bandLevel;
        this.bandTraining = bandTraining;
        this.bandCompetencies = bandCompetencies;
        this.bandResponsibilites = bandResponsibilites;
    }
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
    public void setBandResponsibilities(String bandResponsibilites) {
        this.bandResponsibilites = bandResponsibilites;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BandD bandD = (BandD) o;
        return bandID == bandD.bandID && bandLevel == bandD.bandLevel && Objects.equals(bandName, bandD.bandName) && Objects.equals(bandTraining, bandD.bandTraining) && Objects.equals(bandCompetencies, bandD.bandCompetencies) && Objects.equals(bandResponsibilites, bandD.bandResponsibilites);
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