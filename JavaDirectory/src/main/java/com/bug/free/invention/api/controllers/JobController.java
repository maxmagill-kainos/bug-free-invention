package com.bug.free.invention.api.controllers;

import com.bug.free.invention.api.Models.Job;
import com.bug.free.invention.api.Services.JobService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
    @RequestMapping("/api/jobs")
    public class JobController {

    @Autowired
    private JobService JobService;

    @PostMapping(value = "/submitJobSpec", consumes = "application/json", produces = "application/json")
    public String JobSpecSubmit(@RequestBody ObjectNode objectNode) {
        try {
            String JobSpec = objectNode.get("JobSpec").asText();
            System.out.println(JobSpec);
            if (JobSpec.matches("[a-zA-Z ]+") == false) {
                return "Invalid String";
            }
            ;
            int JobID = objectNode.get("JobID").asInt();
            System.out.println(JobSpec);
            System.out.println(JobID);
            try {
                String dbQuery = "UPDATE JobSummary SET Summary_Text = ? WHERE `Job_ID`=?;";
                Connection DatabaseConnection = DBConfig.getConnection();
                PreparedStatement SubmitSpecForJob = DatabaseConnection.prepareStatement(dbQuery);
                SubmitSpecForJob.setString(1, JobSpec);
                SubmitSpecForJob.setInt(2, JobID);
                System.out.println(SubmitSpecForJob.toString());
                if (SubmitSpecForJob.executeUpdate() == 1) {
                    return "Submitted";
                } else {
                    return "not submitted";
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return "Unsuccessful String submit";
            }
        } catch (NullPointerException IncorrectParameter) {
            return "Unsuccessful String submit";

        }
    }

    @GetMapping("/jobRoles")
    public List<Job> getJobRoles() {
        try {
            List<Job> Jobs = StreamSupport.stream(JobService.retrieveAllJobRoles().spliterator(),false).collect(Collectors.toList());
            return  Jobs;

        } catch (Exception e) {
            List<Job> Jobs = new ArrayList<Job>();
            e.printStackTrace();
            return Jobs;
        }
    }

    @PostMapping(value = "/updateJobRole", consumes = "application/json")
    public void updateJobRole(@RequestBody String jobDetails){
        System.out.println("test");
        JSONObject jobDetailsJSON = new JSONObject(jobDetails);
        try(Connection DatabaseConnection = DBConfig.getConnection()){
            String dbQuery = "UPDATE `job` SET jobTitle = ? , job.bandID = (SELECT band.bandID FROM band WHERE band.bandName = ?), job.jobFamilyID = (SELECT jobFamily.jobFamilyID FROM jobFamily WHERE jobFamily.jobFamilyTitle = ?), job.capabilityID = (SELECT capability.capabilityID FROM capability WHERE capability.capabilityName = ?)  WHERE jobID = ? ;";
            PreparedStatement updateJobTable = DatabaseConnection.prepareStatement(dbQuery);
            updateJobTable.setString(1, String.valueOf(jobDetailsJSON.get("jobTitle")));
            updateJobTable.setString(2, String.valueOf(jobDetailsJSON.get("bandName")));
            updateJobTable.setString(3, String.valueOf(jobDetailsJSON.get("familyName")));
            updateJobTable.setString(4, String.valueOf(jobDetailsJSON.get("capabilityName")));
            updateJobTable.setString(5, String.valueOf(jobDetailsJSON.get("jobID")));
            System.out.println(updateJobTable.toString());
            updateJobTable.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();

        }

    }
/*    @GetMapping("/jobSpec")
    public String getJobSpecLink(@RequestParam Integer JobID) {
        try {
            return JobService.GetJobSpecLink(JobID);
        } catch (Exception e) {
            return "https://www.kainos.com";
        }
    }*/


}

