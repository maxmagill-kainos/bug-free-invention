package com.bug.free.invention.api.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Job {
    @Id int jobID;
    String jobTitle;
    int bandID;
    int capabilityID;
    String bandName;
    String capabilityName;
    int bandlevel;
  
    String familyName;

    public Job(){};
    public Job(int jobID, String jobTitle, int bandID, String bandName, int bandLevel, int capabilityID, String capabilityName, String familyName) {
        this.jobID = jobID;
        this.jobTitle = jobTitle;

        this.bandID = bandID;
        this.bandName = bandName;
        this.bandlevel = bandLevel;

        this.capabilityID = capabilityID;
        this.capabilityName = capabilityName;

        this.familyName = familyName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getCapabilityName() {
        return capabilityName;
    }

    public void setCapabilityName(String capabilityName) {
        this.capabilityName = capabilityName;
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

    public int getBandLevel() {
        return bandlevel;
    }

    public void setBandLevel(int bandlevel) {
        this.bandlevel = bandlevel;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    //    public String getSpec_Summary() {
//        return specSummary;
//    }

//    public void setSpec_Summary(String specSummary) {
//        this.specSummary = specSummary;
//    }

    @Override
    public String toString() {
        return "Job{" +
                "jobID=" + jobID +
                ", jobTitle='" + jobTitle + '\'' +
//                ", jobSpec='" + jobSpec + '\'' +
                ", bandID=" + bandID +
                ", capabilityID=" + capabilityID +
                ", bandName='" + bandName + '\'' +
                ", capabilityName='" + capabilityName + '\'' +
//                ", specSummary='" + specSummary + '\'' +
                '}';
    }
}
