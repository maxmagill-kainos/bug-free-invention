package com.bug.free.invention.api.controllers;

import com.bug.free.invention.api.classes.Job;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

/*    @GetMapping("/jobCapability")
    public String  getJobCapability(){
        System.out.println("Attempting connection");
        try{
            Statement statement = DBConfig.getConnection().createStatement();
            String dbQuery = "SELECT Job.Job_Title, Capability.capabilityName FROM Job JOIN Capability ON(Job.capabilityID = Capability.capabilityID);";
            ResultSet results = statement.executeQuery(dbQuery);
            JSONObject return_json= new JSONObject();
            int i = 0;
            while(results.next()) {
                String job_title = results.getString("Job_Title");
                String capabilityname = results.getString("capabilityName");
                JSONObject tempJson = new JSONObject("{\"job_title\": \"" + job_title + "\", \"capabilityname\": \""+ capabilityname+ "\"}");
                return_json.put(String.valueOf(i), tempJson);
                i++;
            }
            return return_json.toString();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }*/

        @GetMapping("/jobRoles") //US001
        public List<Job> getJobRoles(){
            System.out.println("Attempting connection");
            try{

                Statement statement = DBConfig.getConnection().createStatement();
                String dbQuery = "SELECT Job.jobID, Job.jobTitle, Job.bandID, Capability.capabilityID, Capability.capabilityName, Band.bandName, Band.bandLevel, Job_Family.jobFamilyTitle FROM Job JOIN Capability ON(Job.capabilityID = Capability.capabilityID) JOIN Band ON(Job.bandID = Band.bandID) JOIN Job_Family ON(Job.jobFamilyID = Job_Family.jobFamilyID);";
                ResultSet results = statement.executeQuery(dbQuery);
                List<Job> Jobs = new ArrayList<Job>();
                
                while(results.next()){
                    Jobs.add(new Job(results.getInt("jobID"),results.getString("jobTitle"),
                            results.getInt("capabilityID"),results.getInt("bandID"), results.getString("capabilityName"),
                            results.getString("bandName"), results.getInt("bandLevel"), results.getString("jobFamilyTitle")));

                }
                return Jobs;
            }
            catch (Exception e){
                e.printStackTrace();
                return null;
            }
        };
        @GetMapping("/jobSpec")
        public String getJobSpecLink(@RequestParam Integer JobID){
            String dbQuery = "SELECT 'jobSpec' FROM `Job` WHERE 'jobID' = ?;";
            try(Connection DatabaseConnection = DBConfig.getConnection()){
                PreparedStatement FindJobSpecById = DatabaseConnection.prepareStatement(dbQuery);
                FindJobSpecById.setInt(1,JobID);
                ResultSet results = FindJobSpecById.executeQuery();
                while(results.next()){
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

