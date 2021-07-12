package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.Job;
import com.bug.free.invention.api.controllers.DBConfig;
import org.springframework.context.annotation.Configuration;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class JobService {
    //Load From Database
    private JobRepository repository;

    public void createJobRoles() {
        try {
            List<Job> Jobs = new ArrayList<>();
            Statement statement = DBConfig.getConnection().createStatement();
            //'Job_ID','Capability_ID','Band_ID','Job_Title'
            String dbQuery = "SELECT * FROM `Job` INNER JOIN(Capability,Band,JobSummary) ON (Job.Band_ID = Band.Band_ID) and (Job.Capability_ID = Capability.Capability_ID) and (JobSummary.Job_ID = Job.Job_ID) ";//"GROUP BY 'Capability_ID','Band_ID','Job_Title'";
            ResultSet results = statement.executeQuery(dbQuery);
            while (results.next()) {
                Jobs.add(new Job(results.getInt("Job_ID"), results.getString("Job_Title"), results.getString("Capability_Name"), results.getString("Band_Name"), results.getString("Summary_Text"),results.getString("Job_Spec")));
            }
            Iterable<Job> itrJobs = repository.saveAll(Jobs);
        } catch (Exception e) {

        }
    }

    public String GetJobSpecLink(Integer JobID){
         return  repository.findById(JobID).get().getJob_Spec();

    };

    public Iterable<Job> retrieveAllJobRoles(){
        return repository.findAll();
    }
}

