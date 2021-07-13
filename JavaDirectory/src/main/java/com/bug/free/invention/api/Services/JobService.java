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


    void populateJobRoles() {
        try {
            List<job> jobs = new ArrayList<>();
            List<job> savedJobs = new ArrayList<>();
            Statement statement = DBConfig.getConnection().createStatement();
            System.out.println(DBConfig.url);
            String dbQuerys = "Show tables";
            ResultSet res = statement.executeQuery(dbQuerys);
            while (res.next()){
                System.out.println(res.getString(1));
            }


            //'Job_ID','Capability_ID','Band_ID','Job_Title'
            //String dbQuery = "SELECT * FROM `job` JOIN(Capability,Band,JobSummary) ON (job.Band_ID = Band.Band_ID) and (job.Capability_ID = Capability.Capability_ID) and (JobSummary.Job_ID = job.Job_ID);";//"GROUP BY 'Capability_ID','Band_ID','Job_Title'";
            String dbQuery = "SELECT * FROM job JOIN capability AS C ON job.capabilityID = C.capabilityID JOIN band AS B ON job.bandID = B.bandID JOIN jobSummary AS JS ON JS.jobID = job.jobID;";//"GROUP BY 'Capability_ID','Band_ID','Job_Title'";
            ResultSet results = statement.executeQuery(dbQuery);
            while (results.next()) {
                System.out.println(results.getInt(1));
                jobs.add(new job(results.getInt(1), results.getString(2), results.getString(8), results.getString(10), results.getString(16),results.getString(3)));
                jobs.add(new job());
            }
            Iterable<job> itrJobs = repository.saveAll(jobs);
            itrJobs.forEach(savedJobs::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
       // return args -> {};
    }

    public String GetJobSpecLink(Integer JobID){
         populateJobRoles();
         return  repository.findById(JobID).get().getJobSpec();

    };

    public Iterable<job> retrieveAllJobRoles(){
        populateJobRoles();
        return repository.findAll();
    }
}

