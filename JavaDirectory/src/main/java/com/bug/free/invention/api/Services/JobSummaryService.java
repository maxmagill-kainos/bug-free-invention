package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.jobSummary;
import com.bug.free.invention.api.Models.capability;
import com.bug.free.invention.api.Services.CapabilityRepository;
import com.bug.free.invention.api.Services.JobSummaryRepository;
import com.bug.free.invention.api.controllers.DBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class JobSummaryService {
    @Autowired
    private JobSummaryRepository repository;
    private boolean isPopulated = false;
    public JobSummaryService(JobSummaryRepository repository) {
        this.repository = repository;
    }

    public void populateJobSummary(){
        String dbQuery = "SELECT * FROM jobSummary";
        try(Connection databaseConnection = DBConfig.getConnection()){

            ResultSet results = databaseConnection.createStatement().executeQuery(dbQuery);
            while(results.next()){
                repository.save(new jobSummary(results.getInt("summaryID"),results.getString("summaryText"), results.getInt("jobID")));
            }
            System.out.println("Am Populated");
            isPopulated=true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Iterable<jobSummary> retrieveAllJobSummaries(){
        if(isPopulated == false){
            populateJobSummary();
        }
        return repository.findAll();
    }
}