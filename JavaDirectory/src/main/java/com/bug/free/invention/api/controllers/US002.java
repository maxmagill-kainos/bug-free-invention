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
            String dbQuery = "SELECT Job.Job_Title, Capability.Capability_Name FROM Job JOIN Capability ON(Job.Capability_ID = Capability.Capability_ID);";
            ResultSet results = statement.executeQuery(dbQuery);
            JSONObject return_json= new JSONObject();
            int i = 0;
            while(results.next()) {
                String job_title = results.getString("Job_Title");
                String capability_name = results.getString("Capability_Name");
                JSONObject tempJson = new JSONObject("{\"job_title\": \"" + job_title + "\", \"capability_name\": \""+ capability_name+ "\"}");
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
                String dbQuery = "SELECT Job.Job_ID, Job.Job_Title, Job.Band_ID, Capability.Capability_ID, Capability.Capability_Name, Band.Band_Name, Band.Band_Level, Job_Family.Job_Family_Title FROM Job JOIN Capability ON(Job.Capability_ID = Capability.Capability_ID) JOIN Band ON(Job.Band_ID = Band.Band_ID) JOIN Job_Family ON(Job.Job_Family_ID = Job_Family.Job_Family_ID);";
                ResultSet results = statement.executeQuery(dbQuery);
                List<Job> Jobs = new ArrayList<Job>();
                
                while(results.next()){
                    Jobs.add(new Job(results.getInt("Job_ID"),results.getString("Job_Title"),
                            results.getInt("Capability_ID"),results.getInt("Band_ID"), results.getString("Capability_Name"),
                            results.getString("Band_Name"), results.getInt("Band_Level"), results.getString("Job_Family_Title")));

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
            String dbQuery = "SELECT 'Job_Spec' FROM `Job` WHERE 'Job_ID' = ?;";
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

