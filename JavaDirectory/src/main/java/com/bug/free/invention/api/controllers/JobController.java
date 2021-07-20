package com.bug.free.invention.api.controllers;

import com.bug.free.invention.api.Models.*;
import com.bug.free.invention.api.Services.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.JSONObject;
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

            String JobSpec = objectNode.get("newJobSpecSummary").asText();
            System.out.println(JobSpec);
            if (JobSpec.matches("[a-zA-Z ]+") == false) {
                return "Invalid String";
            }

            int JobID = objectNode.get("jobID").asInt();
            System.out.println(JobSpec);
            System.out.println(JobID);
            try {
                String dbQuery = "UPDATE jobSummary SET summaryText = ? WHERE jobID=?;";
                Connection databaseConnection = DBConfig.getConnection();
                PreparedStatement SubmitSpecForJob = databaseConnection.prepareStatement(dbQuery);
                SubmitSpecForJob.setString(1, JobSpec);
                SubmitSpecForJob.setInt(2, JobID);
                databaseConnection.commit();

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
}

