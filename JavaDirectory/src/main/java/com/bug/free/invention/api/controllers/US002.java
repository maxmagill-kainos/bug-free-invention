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

/*    @GetMapping("/jobcapability")
    public String  getjobcapability(){
        System.out.println("Attempting connection");
        try{
            Statement statement = DBConfig.getConnection().createStatement();
            String dbQuery = "SELECT job.job_Title, capability.capabilityName FROM job JOIN capability ON(job.capabilityID = capability.capabilityID);";
            ResultSet results = statement.executeQuery(dbQuery);
            JSONObject return_json= new JSONObject();
            int i = 0;
            while(results.next()) {
                String job_title = results.getString("job_Title");
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
        public List<Job> getjobRoles(){
            System.out.println("Attempting connection");
            try{

                Statement statement = DBConfig.getConnection().createStatement();
                String dbQuery = "SELECT job.jobID, job.jobTitle, job.bandID, capability.capabilityID, capability.capabilityName, band.bandName, band.bandLevel, jobFamily.jobFamilyTitle FROM job JOIN capability ON(job.capabilityID = capability.capabilityID) JOIN band ON(job.bandID = band.bandID) JOIN jobFamily ON(job.jobFamilyID = jobFamily.jobFamilyID);";
                ResultSet results = statement.executeQuery(dbQuery);
                List<Job> jobs = new ArrayList<Job>();
                
                while(results.next()){
                    jobs.add(new Job(results.getInt("jobID"),results.getString("jobTitle"),
                            results.getInt("capabilityID"),results.getInt("bandID"), results.getString("capabilityName"),
                            results.getString("bandName"), results.getInt("bandLevel"), results.getString("jobFamilyTitle")));

                }
                return jobs;
            }
            catch (Exception e){
                e.printStackTrace();
                return null;
            }
        };
        @GetMapping("/jobSpec")
        public String getjobSpecLink(@RequestParam Integer jobID){
            String dbQuery = "SELECT 'jobSpec' FROM `job` WHERE 'jobID' = ?;";
            try(Connection DatabaseConnection = DBConfig.getConnection()){
                PreparedStatement FindjobSpecById = DatabaseConnection.prepareStatement(dbQuery);
                FindjobSpecById.setInt(1,jobID);
                ResultSet results = FindjobSpecById.executeQuery();
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

