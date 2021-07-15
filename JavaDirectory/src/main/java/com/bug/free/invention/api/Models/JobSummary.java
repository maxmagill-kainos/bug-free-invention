package com.bug.free.invention.api.Models;



import org.springframework.data.relational.core.mapping.Column;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JobSummary {
    @Id
    @Column(value = "summaryID")
    int summaryID;
    @Column(value = "summaryText")
    String summaryText;
    @Column(value = "jobID")
    int jobID;

    public JobSummary(int summaryID, String summaryText, int jobID) {
        this.summaryID = summaryID;
        this.summaryText = summaryText;
        this.jobID = jobID;
    }
}
