package com.bug.free.invention.api.controllers;

import com.bug.free.invention.api.Models.Employee;
import com.bug.free.invention.api.Models.band;
import com.bug.free.invention.api.Models.job;
import com.bug.free.invention.api.Models.capability;
import com.bug.free.invention.api.Services.CapabilityService;
import com.bug.free.invention.api.Services.EmployeeService;
import com.bug.free.invention.api.Services.BandService;
import com.bug.free.invention.api.Services.JobService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/JSONDemo")
    public List<Employee> demoJson() {
        List<Employee> returnList = new ArrayList<Employee>();
        returnList.add(new Employee(1, "name", "difjidsfj"));
        returnList.add(new Employee(2, "ijisdfjdsif", "dsuifjhduisfhui"));
        return returnList;
    }

    ;

    @PostMapping(value = "/submitJobSpec", consumes = "application/json", produces = "application/json")
    public String JobSpecSubmit(@RequestBody ObjectNode objectNode) {
        try {
            String UniqueIdentifier = objectNode.get("UniqueIdentifier").asText();
            int EmployeeID = objectNode.get("employeeID").asInt();
            if(!EmployeeService.IsEmployeeValidAdmin(UniqueIdentifier,EmployeeID)){
                return "False Login";
            };

            String JobSpec = objectNode.get("JobSpec").asText();
            System.out.println(JobSpec);
            if (JobSpec.matches("[a-zA-Z ]+") == false) {
                return "Invalid String";
            }

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
        }
        catch (NullPointerException IncorrectParameter) {
            return "Unsuccessful String submit";

        }

    }

    @GetMapping("/jobRoles")
    public List<job> getJobRoles() {
        try {
            List<band> bands = StreamSupport.stream(bandService.getAllBands().spliterator(),false).collect(Collectors.toList());
            List<capability> capabilities = StreamSupport.stream(capabilityService.retrieveAllCapabilites().spliterator(),false).collect(Collectors.toList());
            List<job> jobs = StreamSupport.stream(JobService.retrieveAllJobRoles().spliterator(),false).collect(Collectors.toList());
            //stream method abandoned
            for(job jobobj : jobs){
                band foundBand = bands.stream().filter(a -> a.getBandID() == jobobj.getBandID()).collect(Collectors.toList()).get(0);
                capability foundCapability = capabilities.stream().filter(a -> a.getCapabilityID() == jobobj.getCapabilityID()).collect(Collectors.toList()).get(0);
                jobobj.setIntband(foundBand);
                jobobj.setIntcapability(foundCapability);
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

