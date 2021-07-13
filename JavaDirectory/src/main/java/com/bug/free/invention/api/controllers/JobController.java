package com.bug.free.invention.api.controllers;

import com.bug.free.invention.api.Models.Employee;
import com.bug.free.invention.api.Models.job;
import com.bug.free.invention.api.Services.EmployeeService;
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
    private EmployeeService EmployeeService;

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
            List<job> jobs = StreamSupport.stream(JobService.retrieveAllJobRoles().spliterator(),false).collect(Collectors.toList());
            return jobs;

        } catch (Exception e) {
            List<job> jobs = new ArrayList<job>();
            e.printStackTrace();
            jobs.add(new job(1, "Test job", 22, 23));
            jobs.add(new job(2, "Test Job2", 23, 24));
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

