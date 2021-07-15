package com.bug.free.invention.api.controllers;

import com.bug.free.invention.api.Models.*;
import com.bug.free.invention.api.Services.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
    @RequestMapping("/api/jobs")
    public class JobController {

    @Autowired
    private JobService JobService;
    @Autowired
    private EmployeeService EmployeeService;
    @Autowired
    private BandService bandService;
    @Autowired
    private CapabilityService capabilityService;
    @Autowired
    private JobSummaryService summaryService;



    @PostMapping(value = "/submitJobSpec", consumes = "application/json", produces = "application/json")
    public String JobSpecSubmit(@RequestBody ObjectNode objectNode) {
        try {
            String UniqueIdentifier = objectNode.get("UniqueIdentifier").asText();
            int EmployeeID = objectNode.get("employeeID").asInt();
            if(EmployeeService.IsEmployeeValidAdmin(UniqueIdentifier,EmployeeID) ==false){
                return "False Login";
            };

            String JobSpec = objectNode.get("jobSpec").asText();
            System.out.println(JobSpec);
            if (JobSpec.matches("[a-zA-Z ]+") == false) {
                return "Invalid String";
            }

            int JobID = objectNode.get("jobID").asInt();
            System.out.println(JobSpec);
            System.out.println(JobID);
            try {
                String dbQuery = "UPDATE jobSummary SET summaryText = ? WHERE jobID=?;";
                Connection DatabaseConnection = DBConfig.getConnection();
                PreparedStatement SubmitSpecForJob = DatabaseConnection.prepareStatement(dbQuery);
                SubmitSpecForJob.setString(1, JobSpec);
                SubmitSpecForJob.setInt(2, JobID);
                DatabaseConnection.commit();

                System.out.println(SubmitSpecForJob.toString());
                int ReturnedValueInsert = SubmitSpecForJob.executeUpdate();
                if (ReturnedValueInsert == 1) {
                    System.out.println("Accepted");
                    summaryService.populateJobSummary();
                    return "Submitted";
                } else {
                    System.out.println(ReturnedValueInsert);
                    return "not submitted";
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return "Unsuccessful String submit";
            }
        }
        catch (NullPointerException IncorrectParameter) {
            //IncorrectParameter.printStackTrace();
            return "Unsuccessful String submit";

        }


    }

    @GetMapping("/jobRoles")
    public List<job> getJobRoles() {
        try {
            List<Band> bands = StreamSupport.stream(bandService.getAllBands().spliterator(),false).collect(Collectors.toList());
            List<capability> capabilities = StreamSupport.stream(capabilityService.retrieveAllCapabilites().spliterator(),false).collect(Collectors.toList());
            List<job> jobs = StreamSupport.stream(JobService.retrieveAllJobRoles().spliterator(),false).collect(Collectors.toList());
            List<jobSummary> summaries= StreamSupport.stream(summaryService.retrieveAllJobSummaries().spliterator(),false).collect(Collectors.toList());
            //stream method abandoned
            for(job jobobj : jobs){
                Band foundBand = bands.stream().filter(a -> a.getBandID() == jobobj.getBandID()).collect(Collectors.toList()).get(0);
                capability foundCapability = capabilities.stream().filter(a -> a.getCapabilityID() == jobobj.getCapabilityID()).collect(Collectors.toList()).get(0);
                System.out.println("Trying to Match "+jobobj.getJobID());
                jobSummary foundSummary = summaries.stream().filter(a -> a.getJobID() == jobobj.getJobID()).collect(Collectors.toList()).get(0);
                System.out.println(foundSummary);
                try {
                    jobobj.setIntband(foundBand);

                }
                catch (Exception e) {
                }
                try {
                    jobobj.setIntcapability(foundCapability);
                }catch (Exception e){}
                try {
                    jobobj.setIntJobSummary(foundSummary);
                }catch (Exception e){}
            }


            return jobs;

        } catch (Exception e) {
            List<job> jobs = new ArrayList<job>();
            e.printStackTrace();

            return jobs;
        }
    }


    @GetMapping("/jobSpec")
    public String getJobSpecLink(@RequestParam Integer JobID) {
        try {
            return JobService.GetJobSpecLink(JobID);
        } catch (Exception e) {
            return "https://www.kainos.com";
        }
    }


}

