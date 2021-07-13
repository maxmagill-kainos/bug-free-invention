package com.bug.free.invention.api.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "job")
public class job {
    @Id int jobID;
    String jobTitle;
    String jobSpec;
    @OneToOne(targetEntity = band.class,mappedBy = "bandID")
    int bandID;
    @OneToOne(targetEntity = capability.class,mappedBy = "capabilityID")
    int capabilityID;
    String bandName;
    String capabilityName;
    String summaryText;
    public job(){};
    public job(int jobID, String jobTitle, String jobSpec, int bandID, int capabilityID) {
        this.jobID = jobID;
        this.jobTitle = jobTitle;
        this.jobSpec = jobSpec;
        this.bandID = bandID;
        this.capabilityID = capabilityID;
    }

    public job(int jobID, String jobTitle, int bandID, int capabilityID) {
        this.jobID = jobID;
        this.jobTitle = jobTitle;

        this.bandID = bandID;
        this.capabilityID = capabilityID;
    }
    public job(int job_ID, String job_Title, String bandName, String capabilityName, String summaryText) {
        this.jobID = job_ID;
        this.jobTitle = job_Title;
        this.bandName = bandName;
        this.capabilityName = capabilityName;
        this.summaryText = summaryText;
    }
    public job(int job_ID, String job_Title, String bandName, String capabilityName, String summaryText, String job_Spec) {
        this.jobID = job_ID;
        this.jobTitle = job_Title;
        this.bandName = bandName;
        this.capabilityName = capabilityName;
        this.summaryText = summaryText;
        this.jobSpec = job_Spec;
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

    public String getbandName() {
        return bandName;
    }

    public void setbandName(String bandName) {
        this.bandName = bandName;
    }

    public String getCapabilityName() {
        return capabilityName;
    }

    public void setCapabilityName(String capabilityName) {
        this.capabilityName = capabilityName;
    }

    public String getSummaryText() {
        return summaryText;
    }

    public void setSummaryText(String summaryText) {
        this.summaryText = summaryText;
    }

    @Override
    public String toString() {
        return "job{" +
                "jobID=" + jobID +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobSpec='" + jobSpec + '\'' +
                ", bandID=" + bandID +
                ", capabilityID=" + capabilityID +
                ", bandName='" + bandName + '\'' +
                ", capabilityName='" + capabilityName + '\'' +
                ", summaryText='" + summaryText + '\'' +
                '}';
    }
}

