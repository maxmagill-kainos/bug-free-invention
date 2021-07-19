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

            //'Job_ID','Capability_ID','Band_ID','Job_Title'
            String dbQuery = "SELECT job.* , band.* , capability.* , jobFamily.* FROM job INNER JOIN(capability,band,jobFamily) ON (job.bandID = band.bandID) and (job.capabilityID = capability.capabilityID) and (job.jobFamilyID = jobFamily.jobFamilyID);";//"GROUP BY 'Capability_ID','Band_ID','Job_Title'";
            ResultSet results = statement.executeQuery(dbQuery);
            while (results.next()) {
                jobs.add(new job(Integer.parseInt(results.getString("jobID")),
                        results.getString("jobTitle"),
                        Integer.parseInt(results.getString("bandID")),
                        results.getString("bandName"),
                        Integer.parseInt(results.getString("bandLevel")),
                        Integer.parseInt(results.getString("capabilityID")),
                        results.getString("capabilityName"),
                        results.getString("jobFamilyTitle")));
            }
            Iterable<job> itrJobs = repository.saveAll(jobs);
            itrJobs.forEach(savedJobs::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
       // return args -> {};
    }

//    public String GetJobSpecLink(Integer JobID){
//         populateJobRoles();
//         return  repository.findById(JobID).get().getJob_Spec();
//
//    };

    public Iterable<job> retrieveAllJobRoles(){
        populateJobRoles();
        return repository.findAll();
    }
}

