package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.Job;
import com.bug.free.invention.api.controllers.DBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class JobService {
    //Load From Database
    @Autowired
    private JobRepository repository;


    void populateJobRoles() {
        try {
            List<Job> Jobs = new ArrayList<>();
            List<Job> savedJobs = new ArrayList<>();
            Statement statement = DBConfig.getConnection().createStatement();
            System.out.println(DBConfig.url);

            //'Job_ID','Capability_ID','Band_ID','Job_Title'
            String dbQuery = "SELECT * FROM Job INNER JOIN(Capability,Band,JobSummary) ON (Job.Band_ID = Band.Band_ID) and (Job.Capability_ID = Capability.Capability_ID) and (JobSummary.Job_ID = Job.Job_ID);";//"GROUP BY 'Capability_ID','Band_ID','Job_Title'";
            ResultSet results = statement.executeQuery(dbQuery);
            while (results.next()) {
                Jobs.add(new Job(results.getInt("Job_ID"), results.getString("Job_Title"), results.getString("Capability_Name"), results.getString("Band_Name"), results.getString("Summary_Text"),results.getString("Job_Spec")));
            }
            Iterable<Job> itrJobs = repository.saveAll(Jobs);
            itrJobs.forEach(savedJobs::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
       // return args -> {};
    }

    public String GetJobSpecLink(Integer JobID){
         populateJobRoles();
         return  repository.findById(JobID).get().getJob_Spec();

    };

    public Iterable<Job> retrieveAllJobRoles(){
        //populateJobRoles();
        return repository.findAll();
    }
}

