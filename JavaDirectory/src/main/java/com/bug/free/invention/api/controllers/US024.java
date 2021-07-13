package com.bug.free.invention.api.controllers;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@RestController
@RequestMapping("/api/login")
public class US024 {

    @PostMapping(value = "/AuthLogin", consumes = "application/json")
    public String validateLogin(@RequestBody String authDetails){
        JSONObject userDetails = new JSONObject(authDetails);
        String dbQuery = "SELECT `employeeID`,`isAdmin` FROM `employee` WHERE `username` = ? AND `userPassword` = ? LIMIT 1;";
        try(Connection DatabaseConnection = DBConfig.getConnection()){
            PreparedStatement validateUserLogin = DatabaseConnection.prepareStatement(dbQuery);
            validateUserLogin.setString(1, String.valueOf(userDetails.get("Email")));
            validateUserLogin.setString(2, String.valueOf(userDetails.get("Password")));
            ResultSet results = validateUserLogin.executeQuery();
            while(results.next()){
                return "{\"employeeID\": \"" + results.getString("employeeID") + "\", \"isAdmin\": \""+ results.getString("isAdmin")+ "\"}";
            }
        }
        catch (Exception e){
            e.printStackTrace();

        }
        return "{\"response\": \"Incorrect Username or Password\"}";
    }
}
