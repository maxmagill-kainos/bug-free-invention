package com.bug.free.invention.api.classes;

public class Job {
    int jobID;
    String jobTitle;
    String jobSpec;
    int bandId;
    int capabilityId;
    String capabilityName;
    String bandName;
    String familyName;
    int bandLevel;

    public Job(int jobID, String jobTitle, String jobSpec, int bandId, int capabilityId, String capabilityName) {
        this.jobID = jobID;
        this.jobTitle = jobTitle;
        this.jobSpec = jobSpec;
        this.bandId = bandId;
        this.capabilityId = capabilityId;
        this.capabilityName = capabilityName;
    }

    public Job(int jobID, String jobTitle, int bandId, int capabilityId, String capabilityName, String bandName, int bandLevel, String familyName) {
        this.jobID = jobID;
        this.jobTitle = jobTitle;
        this.bandId = bandId;
        this.capabilityId = capabilityId;
        this.capabilityName = capabilityName;
        this.bandName = bandName;
        this.bandLevel = bandLevel;
        this.familyName = familyName;
    }

    public int getJob_ID() {
        return jobID;
    }

    public void setJob_ID(int job_ID) {
        jobID = job_ID;
    }

    public String getJob_Title() {
        return jobTitle;
    }

    public void setJob_Title(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJob_Spec() {
        return jobSpec;
    }

    public void setJob_Spec(String jobSpec) {
        this.jobSpec = jobSpec;
    }

    public int getBand_ID() {
        return bandId;
    }

    public void setBand_ID(int bandId) {
        this.bandId = bandId;
    }

    public int getCapability_ID() {
        return capabilityId;
    }

    public void setCapability_ID(int capabilityId) {
        this.capabilityId = capabilityId;
    }

    public void setCapability_name(String capabilityName) { this.capabilityName = capabilityName; }

    public String getCapability_name() { return capabilityName; }

    public String getCapability_Name() {
        return capabilityName;
    }

    public void setCapability_Name(String capabilityName) {
        this.capabilityName = capabilityName;
    }

    public String getBand_Name() {
        return bandName;
    }

    public void setBand_Name(String bandName) {
        this.bandName = bandName;
    }

    public String getFamily_Name() {
        return familyName;
    }

    public void setFamily_Name(String familyName) {
        this.familyName = familyName;
    }

    public int getBand_Level() {
        return bandLevel;
    }

    public void setBand_Level(int bandLevel) {
        this.bandLevel = bandLevel;
    }
}
