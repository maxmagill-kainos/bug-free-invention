package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.job;
import com.bug.free.invention.api.controllers.DBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class JobService {
    //Load From Database
    @Autowired
    private JobRepository repository;
    @Autowired
    private BandService bandService;
    @Autowired
    private CapabilityService capabilityService;

    private boolean HasRunBefore = false;
    void populateJobRoles() {
        try {
            List<job> jobs = new ArrayList<>();
            List<job> savedJobs = new ArrayList<>();
            Statement statement = DBConfig.getConnection().createStatement();
            System.out.println(DBConfig.url);
            String dbQuery = "SELECT * FROM job";



            ResultSet results = statement.executeQuery(dbQuery);
            while (results.next()) {
                job TempJob = new job(results.getInt("jobID"), results.getString("jobTitle"),results.getString("jobSpec"),results.getInt("jobFamilyID"),results.getInt("bandID"),results.getInt("capabilityID"));// results.getString(8), results.getString(10), results.getString(16),results.getString(3)));
                jobs.add(TempJob);

            }
            HasRunBefore = true;
            Iterable<job> itrJobs = repository.saveAll(jobs);
            itrJobs.forEach(savedJobs::add);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String GetJobSpecLink(Integer JobID){
        if(HasRunBefore == false){
            populateJobRoles();
        }
        System.out.println(repository.findById(JobID).get().getJobSpec());
         return  repository.findById(JobID).get().getJobSpec();

    };

    public Iterable<job> retrieveAllJobRoles(){
        if(HasRunBefore == false){
            populateJobRoles();
        }
        return repository.findAll();
    }
}

