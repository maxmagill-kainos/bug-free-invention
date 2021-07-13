package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.Employee;
import com.bug.free.invention.api.Models.IncorrectPermissonException;
import com.bug.free.invention.api.controllers.DBConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeService {

    private EmployeeRepository repository;



    public String LogInEmployee(String username, String password){
        String dbQuery = "SELECT * FROM `employee` WHERE `username` = ? AND `userPassword` = ? LIMIT 1;";
        try(Connection DatabaseConnection = DBConfig.getConnection()){
            PreparedStatement validateUserLogin = DatabaseConnection.prepareStatement(dbQuery);
            validateUserLogin.setString(1,username);
            validateUserLogin.setString(2, password);
            ResultSet results = validateUserLogin.executeQuery();
            while(results.next()){
                repository.save(new Employee(results.getInt("employeeID"),results.getString("fName").concat(results.getString("lName")),
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
            Employee EmployeeToCheck ;
            if(repository.findById(EmployeeID).isPresent()) {

                EmployeeToCheck = repository.findById(EmployeeID).get();
            }
            else{
                return false;
            }

            if(EmployeeToCheck.getUUID() == UniqueIdentifier && EmployeeToCheck.isAdmin()){
                return true;
            }
            else {
                throw new IncorrectPermissonException("invalid login");
            }

        }
        catch (IncorrectPermissonException e){
            return false;
        }

    }
}
