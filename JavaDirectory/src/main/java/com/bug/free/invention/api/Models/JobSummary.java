package com.bug.free.invention.api.Models;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(value = "jobSummary")
public class jobSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(value = "summaryID")
    int summaryID;
    @Column(value = "summaryText")
    String summaryText;
    @Column(value = "jobID")
    int jobID;

    public jobSummary() {
    }

    public jobSummary(int summaryID, String summaryText, int jobID) {
        this.summaryID = summaryID;
        this.summaryText = summaryText;
        this.jobID = jobID;
    }

    public int getSummaryID() {
        return summaryID;
    }

    public void setSummaryID(int summaryID) {
        this.summaryID = summaryID;
    }

    public String getSummaryText() {
        return summaryText;
    }

    public void setSummaryText(String summaryText) {
        this.summaryText = summaryText;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }
}
