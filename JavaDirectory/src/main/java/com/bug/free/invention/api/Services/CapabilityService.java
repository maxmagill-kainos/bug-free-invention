package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.Employee;
import com.bug.free.invention.api.Models.capability;
import com.bug.free.invention.api.Models.job;
import com.bug.free.invention.api.controllers.DBConfig;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CapabilityService {
    private CapabilityRepository repository;


    public void populateCapability(){
        String dbQuery = "SELECT * FROM `capability`";
        try(Connection DatabaseConnection = DBConfig.getConnection()){

            ResultSet results = DatabaseConnection.createStatement().executeQuery(dbQuery);
            while(results.next()){
                System.out.println(results.getInt(1));
                repository.save(new capability(results.getInt(1),results.getString(2)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Iterable<capability> retrieveAllCapabilites(){
        populateCapability();
        return repository.findAll();
    }
}
