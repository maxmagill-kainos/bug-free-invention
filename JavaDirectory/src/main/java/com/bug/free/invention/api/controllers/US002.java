package com.bug.free.invention.api.controllers;

import com.bug.free.invention.api.classes.Job;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mysql.cj.xdevapi.JsonArray;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
    @RequestMapping("/api/jobs")
    public class US002 {

        @GetMapping("/JSONDemo")
        public List<Employee> demoJson(){
            List<Employee> returnList = new ArrayList<Employee>();
            returnList.add(new Employee(1,"name","difjidsfj"));
            returnList.add(new Employee(2,"ijisdfjdsif","dsuifjhduisfhui"));
            return returnList;
        };

    @PostMapping(value = "/submitJobSpec", consumes = "application/json", produces = "application/json")
    public String JobSpecSubmit(@RequestBody ObjectNode objectNode) {
    String JobSpec = objectNode.get("JobSpec").asText();
    int JobID = objectNode.get("JobID").asInt();
    System.out.println(JobSpec);
        System.out.println(JobID);
        try{
            String dbQuery = "UPDATE`JobSummary` SET Summary_Text = ? WHERE `Job_ID`=?;";
            Connection DatabaseConnection = DBConfig.getConnection();
            PreparedStatement SubmitSpecForJob = DatabaseConnection.prepareStatement(dbQuery);
            SubmitSpecForJob.setString(1,JobSpec);
            SubmitSpecForJob.setInt(2,JobID);
            if(SubmitSpecForJob.executeUpdate()==1) {
                return "Submitted";
            }
            else{
                return "not submitted";
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            return "Unsuccessful String submit";
        }
    };

        @GetMapping("/jobRoles")
        public List<Job> getJobRoles(){
            List<Job> Jobs = new ArrayList<Job>();
            try{

                Statement statement = DBConfig.getConnection().createStatement();
                //'Job_ID','Capability_ID','Band_ID','Job_Title'
                String dbQuery = "SELECT * FROM `Job` INNER JOIN(Capability,Band,JobSummary) ON (Job.Band_ID = Band.Band_ID) and (Job.Capability_ID = Capability.Capability_ID) and (JobSummary.Job_ID = Job.Job_ID) ";//"GROUP BY 'Capability_ID','Band_ID','Job_Title'";
                ResultSet results = statement.executeQuery(dbQuery);

                
                while(results.next()){
                    Jobs.add(new Job(results.getInt("Job_ID"),results.getString("Job_Title"),results.getString("Capability_Name"),results.getString("Band_Name"),results.getString("Summary_Text")));
                }
                return Jobs;

            }
            catch (Exception e){
                e.printStackTrace();
                Jobs.add(new Job(1,"Test Job",22,23));
                Jobs.add(new Job(2,"Test Job2",23,24));
                return Jobs;
            }
        };
        @GetMapping("/jobSpec")
        public String getJobSpecLink(@RequestParam Integer JobID){
            String dbQuery = "SELECT `Job_Spec` FROM `Job` WHERE `Job_ID` = ?;";
            try(Connection DatabaseConnection = DBConfig.getConnection()){
                PreparedStatement FindJobSpecById = DatabaseConnection.prepareStatement(dbQuery);
                FindJobSpecById.setInt(1,JobID);
                ResultSet results = FindJobSpecById.executeQuery();
                while(results.next()){
                    return results.getString("Job_Spec");
                }
                return "https://www.google.com";
            }
            catch (Exception e){
                e.printStackTrace();

            }
          return  "";
        };




}

