package com.bug.free.invention.api.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

    private  static String Username = ;
    private static String Password = ;
    private static String host =;

    public DBConfig(){

    }

    public static Connection getConnection(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://"+ host + "/teamC_Josh?useSSL=false", Username, Password);
            return conn;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}