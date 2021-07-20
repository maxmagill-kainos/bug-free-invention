package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.employee;
import com.bug.free.invention.api.Models.IncorrectPermissonException;
import com.bug.free.invention.api.controllers.DBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;



    public String LogInEmployee(String username, String password){
        String dbQuery = "SELECT * FROM `employee` WHERE `username` = ? AND `userPassword` = ? LIMIT 1;";
        try(Connection DatabaseConnection = DBConfig.getConnection()){
            PreparedStatement validateUserLogin = DatabaseConnection.prepareStatement(dbQuery);
            validateUserLogin.setString(1,username);
            validateUserLogin.setString(2, password);
            ResultSet results = validateUserLogin.executeQuery();
            while(results.next()){
                repository.save(new employee(results.getInt("employeeID"),results.getString("fName"),results.getString("lName"),
                        results.getString("uniqueID"),results.getBoolean("isAdmin")));
                return "{\"employeeID\": \"" + results.getString("employeeID") + "\", \"isAdmin\": \""+ results.getString("isAdmin")+ "\"}";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "{\"response\": \"Incorrect Username or Password\"}";
    }
    public boolean IsEmployeeValidAdmin(String UniqueIdentifier,Integer EmployeeID){
        try{
            employee employeeToCheck;
            employeeToCheck = repository.findById(EmployeeID).get();


            if(employeeToCheck.getUUID().equals(UniqueIdentifier) && employeeToCheck.isAdmin()==true){
                return true;
            }
            else {
                System.out.println(employeeToCheck.toString());
                throw new IncorrectPermissonException("invalid login");
            }

        }
        catch (IncorrectPermissonException e){
            return false;
        }

    }
}
