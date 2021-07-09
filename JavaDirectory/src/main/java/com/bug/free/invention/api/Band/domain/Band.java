package com.bug.free.invention.api.Band.domain;

import javax.persistence.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Objects;

@Entity
@Table(value = "Band")
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int bandId;
    @Column(value = "Band_Name")
    String bandName;
    @Column(value = "Band_Level")
    int bandLevel;
    @Column(value = "Band_Training")
    String bandTraining;
    @Column(value = "Band_Competencies")
    String bandCompetencies;
    @Column(value = "Band_Responsibilites")
    String bandResponsibilities;

    public Band() {}

    public Band(int bandId, String bandName, int bandLevel, String bandTraining, String bandCompetencies, String bandResponsibilities) {
        this.bandId = bandId;
        this.bandName = bandName;
        this.bandLevel = bandLevel;
        this.bandTraining = bandTraining;
        this.bandCompetencies = bandCompetencies;
        this.bandResponsibilities = bandResponsibilities;
    }

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
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
        Band band = (Band) o;
        return bandId == band.bandId && bandLevel == band.bandLevel && Objects.equals(bandName, band.bandName) && Objects.equals(bandTraining, band.bandTraining) && Objects.equals(bandCompetencies, band.bandCompetencies) && Objects.equals(bandResponsibilities, band.bandResponsibilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bandId, bandName, bandLevel, bandTraining, bandCompetencies, bandResponsibilities);
    }

    @Override
    public String toString() {
        return "Band{" +
                "bandId=" + bandId +
                ", bandName='" + bandName + '\'' +
                ", bandLevel=" + bandLevel +
                ", bandTraining='" + bandTraining + '\'' +
                ", bandCompetencies='" + bandCompetencies + '\'' +
                ", bandResponsibilities='" + bandResponsibilities + '\'' +
                '}';
    }
}
