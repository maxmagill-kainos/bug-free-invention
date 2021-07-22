package com.bug.free.invention.api.Models;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(value = "jobFamily")
public class jobFamily {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(value = "jobFamilyID")
    private int jobFamilyID;
    @Column(value = "jobFamilyTitle")
    private String jobFamilyTitle;
    @Column(value = "capabilityID")
    private int capabilityID;
    public jobFamily() {
    }
    public jobFamily(int jobFamilyID, String jobFamilyTitle, int capabilityID) {
        this.jobFamilyID = jobFamilyID;
        this.jobFamilyTitle = jobFamilyTitle;
        this.capabilityID = capabilityID;
    }

    public int getJobFamilyID() {
        return jobFamilyID;
    }

    public void setJobFamilyID(int jobFamilyID) {
        this.jobFamilyID = jobFamilyID;
    }

    public String getJobFamilyTitle() {
        return jobFamilyTitle;
    }

    public void setJobFamilyTitle(String jobFamilyTitle) {
        this.jobFamilyTitle = jobFamilyTitle;
    }

    public int getCapabilityID() {
        return capabilityID;
    }

    public void setCapabilityID(int capabilityID) {
        this.capabilityID = capabilityID;
    }
}
