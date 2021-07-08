package com.bug.free.invention.api.controllers;

import com.bug.free.invention.api.classes.Job;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.JsonArray;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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

        @GetMapping("/jobRoles")
        public List<Job> getJobRoles(){
            List<Job> Jobs = new ArrayList<Job>();
            try{

                Statement statement = DBConfig.getConnection().createStatement();
                //'Job_ID','Capability_ID','Band_ID','Job_Title'
                String dbQuery = "SELECT * FROM `Job` INNER JOIN(Capability,Band) ON (Job.Band_ID = Band.Band_ID) and (Job.Capability_ID = Capability.Capability_ID) ";//"ROUP BY 'Capability_ID','Band_ID','Job_Title'";
                ResultSet results = statement.executeQuery(dbQuery);

                
                while(results.next()){
                    Jobs.add(new Job(results.getInt("Job_ID"),results.getString("Job_Title"),results.getString("Capability_Name"),results.getString("Band_Name")));

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




        @GetMapping("/WorkdayScraper")
        public void WorkDayScraper(){
            String test = "SELECT Job_Title,Capability_ID,Band_ID FROM Job JOIN ";
        }
    }

