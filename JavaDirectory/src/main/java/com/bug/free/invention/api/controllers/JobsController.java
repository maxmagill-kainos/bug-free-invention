package com.bug.free.invention.api.controllers;

import com.bug.free.invention.api.classes.Job;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {

    @GetMapping("/jobRoles") //US001
    public List<Job> getJobRoles() throws SQLException {
        try{

            Statement statement = DBConfig.getConnection().createStatement();
            String dbQuery = "SELECT job.jobID, job.jobTitle, job.bandID, capability.capabilityID, capability.capabilityName, band.bandName, band.bandLevel, jobFamily.jobFamilyTitle FROM job JOIN capability ON(job.capabilityID = capability.capabilityID) JOIN band ON(job.bandID = band.bandID) JOIN jobFamily ON(job.jobFamilyID = jobFamily.jobFamilyID);";
            ResultSet results = statement.executeQuery(dbQuery);
            List<Job> jobs = new ArrayList<>();

            while(results.next()){
                jobs.add(new Job(results.getInt("jobID"),results.getString("jobTitle"),
                        results.getInt("capabilityID"),results.getInt("bandID"), results.getString("capabilityName"),
                        results.getString("bandName"), results.getInt("bandLevel"), results.getString("jobFamilyTitle")));

            }
            return jobs;
        }
        catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    };

    @GetMapping("/jobSpec")
    public String getJobSpecLink(@RequestParam Integer JobID){
        String dbQuery = "SELECT 'jobSpec' FROM `Job` WHERE 'jobID' = ?;";
        try(Connection databaseConnection = DBConfig.getConnection()){
            PreparedStatement findJobSpecById = databaseConnection.prepareStatement(dbQuery);
            findJobSpecById.setInt(1,JobID);
            ResultSet results = findJobSpecById.executeQuery();
            if(results.next()){
                return results.getString("jobSpec");
            }
            return "https://www.google.com";
        }
        catch (Exception e){
            e.printStackTrace();

        }
      return  "";
    };
}

