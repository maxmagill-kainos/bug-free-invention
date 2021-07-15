package com.bug.free.invention.api.Models;



import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "job")
public class job {
    @Column(name = "jobID")
    @Id
    int jobID;
    @Column(name = "jobTitle")
    String jobTitle;
    @Column(name = "jobSpec")
    String jobSpec;
    @Column(name = "jobFamilyID")
    int jobFamilyID;
    @Column(name = "bandID")
    int bandID = 1;
    @Column(name = "capabilityID")
    int capabilityID = 1;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private Band intband;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private capability intcapability;




    public job() {

    };
    public job(int jobID, String jobTitle, String jobSpec, int jobFamilyID) {
        this.jobID = jobID;
        this.jobTitle = jobTitle;
        this.jobSpec = jobSpec;
        this.jobFamilyID = jobFamilyID;

    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobSpec() {
        return jobSpec;
    }

    public void setJobSpec(String jobSpec) {
        this.jobSpec = jobSpec;
    }

    public int getJobFamilyID() {
        return jobFamilyID;
    }

    public void setJobFamilyID(int jobFamilyID) {
        this.jobFamilyID = jobFamilyID;
    }

    public job(int jobID, String jobTitle, String jobSpec, int jobFamilyID, int bandID, int capabilityID) {
        this.jobID = jobID;
        this.jobTitle = jobTitle;
        this.jobSpec = jobSpec;
        this.jobFamilyID = jobFamilyID;
        this.bandID = bandID;
        this.capabilityID = capabilityID;
    }

    public int getBandID() {
        return bandID;
    }

    public void setBandID(int bandID) {
        this.bandID = bandID;
    }

    public int getCapabilityID() {
        return capabilityID;
    }

    public void setCapabilityID(int capabilityID) {
        this.capabilityID = capabilityID;
    }

    public Band getIntband() {
        return intband;
    }

    public void setIntband(Band intband) {
        this.intband = intband;
    }

    public capability getIntcapability() {
        return intcapability;
    }

    public void setIntcapability(capability intcapability) {
        this.intcapability = intcapability;
    }

    @Override
    public String toString() {
        return "job{" +
                "jobID=" + jobID +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobSpec='" + jobSpec + '\'' +
                ", jobFamilyID=" + jobFamilyID +
                ", bandID=" + bandID +
                ", capabilityID=" + capabilityID +
                ", band_Name=" + intband.getBandName()+
                '}';
    }
}

