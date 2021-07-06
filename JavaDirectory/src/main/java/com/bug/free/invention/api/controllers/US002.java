package com.bug.free.invention.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        }
        @GetMapping("/api/test")
        public String getJobRoles(){
            try{

                Statement statement = DBConfig.getConnection().createStatement();
                String dbQuery = "SELECT 'Job_ID','Capability_ID','Band_ID','Job_Title' FROM `Job` GROUP BY 'Capability_ID','Band_ID','Job_Title'";
                ResultSet results = statement.executeQuery(dbQuery);
                return results.toString();
            }
            catch (Exception e){
                e.printStackTrace();
                return null;
            }
        };

        public String getJobSpecLink(Integer JobID){
            String dbQuery = "SELECT 'Job_Spec' FROM `Job` WHERE 'Job_ID' = ?;";
            try(Connection DatabaseConnection = DBConfig.getConnection()){
                PreparedStatement FindJobSpecById = DatabaseConnection.prepareStatement(dbQuery);
                FindJobSpecById.setInt(1,JobID);
                ResultSet results = FindJobSpecById.executeQuery();

                DatabaseConnection.commit();
                return results.getString("Job_Spec");
            }
            catch (Exception e){
                e.printStackTrace();

            }
          return  "";
        };
    }

