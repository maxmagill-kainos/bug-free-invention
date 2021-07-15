package com.bug.free.invention.api.controllers;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConfig {

    private  static String Username = "AnnaP";
    private static String Password = "tempPwd!" ;
    private static String host = "academy2020.cpc8rvmbbd9k.eu-west-2.rds.amazonaws.com";
    private static String DatabaseID = "teamCteam_AnnaP";

    public DBConfig(){
    }
    public static void DBInit(){
        if(System.getenv("BUGFREEDBUSERNAME") != null){
            Username = System.getenv("BUGFREEDBUSERNAME");
            Password = System.getenv("BUGFREEDBPASSWORD");
            host = System.getenv("BUGFREEDBHOST");

        }
    }
    private String getDatabaseName(){
        return DatabaseID;
    }

    public static Connection getConnection(){
        DBInit();
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://"+ host + "/"+DatabaseID+"?useSSL=false", Username, Password);
            return conn;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public static boolean TestMode(){
        DatabaseID = "teamCteam_AnnaP";
        return true;
    }
    public static boolean ProdMode(){
        DatabaseID = "teamCteam_AnnaP";
        return true;
    };
}