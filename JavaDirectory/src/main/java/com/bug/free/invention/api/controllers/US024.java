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
        String dbQuery = "SELECT `Employee_ID`,`is_Admin` FROM `Employee` WHERE `Username` = ? AND `User_Password` = ? LIMIT 1;";
        try(Connection DatabaseConnection = DBConfig.getConnection()){
            PreparedStatement validateUserLogin = DatabaseConnection.prepareStatement(dbQuery);
            validateUserLogin.setString(1, String.valueOf(userDetails.get("Email")));
            validateUserLogin.setString(2, String.valueOf(userDetails.get("Password")));
            ResultSet results = validateUserLogin.executeQuery();
            while(results.next()){
                return "{\"Employee_ID\": \"" + results.getString("Employee_ID") + "\", \"is_Admin\": \""+ results.getString("is_Admin")+ "\"}";
            }
        }
        catch (Exception e){
            e.printStackTrace();

        }
        return "{\"response\": \"Incorrect Username or Password\"}";
    };
}
