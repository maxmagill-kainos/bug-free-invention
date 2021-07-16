package com.bug.free.invention.api.classes;

public class Job {
    private int jobID;
    private String jobTitle;
    private String jobSpec;
    private int bandId;
    private int capabilityId;
    private String capabilityName;
    private String bandName;
    private String familyName;
    private int bandLevel;

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

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }

    public int getCapabilityId() {
        return capabilityId;
    }

    public void setCapabilityId(int capabilityId) {
        this.capabilityId = capabilityId;
    }

    public String getCapabilityName() {
        return capabilityName;
    }

    public void setCapabilityName(String capabilityName) {
        this.capabilityName = capabilityName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getBandLevel() {
        return bandLevel;
    }

    public void setBandLevel(int bandLevel) {
        this.bandLevel = bandLevel;
    }
}
