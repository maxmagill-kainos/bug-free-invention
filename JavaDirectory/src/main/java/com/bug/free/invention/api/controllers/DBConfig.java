package com.bug.free.invention.api.controllers;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConfig {
    private  static String Username ="" ;
    private static String Password = "";
    private static String host = "";
    private static String DatabaseID = "teamC_Josh";
    public DBConfig(){
    }
    public  void DBInit(){
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
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://"+ host + "/"+DatabaseID+"?useSSL=false", Username, Password);
            return conn;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public static boolean TestMode(){
        DatabaseID = "teamC_Josh";
        return true;
    }
    public static boolean ProdMode(){
        DatabaseID = "teamC_Josh";
        return true;
    };
}