package com.bug.free.invention.api.controllers;

import org.apache.catalina.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
    private  static String Username = "";
    private static String Password = "" ;
    private static String host = "";
    private static String DatabaseID = "teamCteam_Josh";
    public static String url = "jdbc:mysql://"+ host + "/"+DatabaseID+"?useSSL=false";
    public DBConfig(){

    }

    public static Connection getConnection(){
        try{
            Connection conn = DriverManager.getConnection(url, Username, Password);
            return conn;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public static boolean TestMode(){

        DatabaseID = "teamC_Josh";
        url = "jdbc:h2:mem:teamC_josh;MODE=MYSQL;DATABASE_TO_UPPER=false;IGNORECASE=TRUE";
        Username = "sa";
        Password ="";
        System.out.println("in Test Mode : "+Username);
        return true;
    }
    public static boolean ProdMode(){
        DatabaseID = "";
        Username = "";
        Password = "";
        url = "jdbc:mysql://"+ host + "/"+DatabaseID+"?useSSL=false";
        return true;
    };
}
