package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.jobFamily;
import com.bug.free.invention.api.Models.jobSummary;
import com.bug.free.invention.api.Models.capability;
import com.bug.free.invention.api.Services.CapabilityRepository;
import com.bug.free.invention.api.Services.JobFamilyRepository;
import com.bug.free.invention.api.controllers.DBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class JobFamilyService {
    @Autowired
    private JobFamilyRepository repository;
    private boolean isPopulated = false;
    public JobFamilyService(JobFamilyRepository repository) {
        this.repository = repository;
    }

    public void populateJobFamilies(){
        String dbQuery = "SELECT * FROM jobFamily";
        try(Connection databaseConnection = DBConfig.getConnection()){

            ResultSet results = databaseConnection.createStatement().executeQuery(dbQuery);
            while(results.next()){
                repository.save(new jobFamily(results.getInt("jobFamilyID"),results.getString("jobFamilyTitle"), results.getInt("capabilityID")));
            }
            System.out.println("Am Populated");
            isPopulated=true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Iterable<jobFamily> retrieveAllJobFamilies(){
        if(isPopulated == false){
            populateJobFamilies();
        }
        return repository.findAll();
    }
}