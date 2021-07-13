package com.bug.free.invention.api.Models;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JobSummary {
    @Id
    int summaryID;
    String summaryText;
    int jobID;

    public JobSummary(int summaryID, String summaryText, int jobID) {
        this.summaryID = summaryID;
        this.summaryText = summaryText;
        this.jobID = jobID;
    }
}
