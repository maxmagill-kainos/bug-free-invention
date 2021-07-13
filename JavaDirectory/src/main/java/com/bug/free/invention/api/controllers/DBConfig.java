package com.bug.free.invention.api.controllers;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConfig {
    private  static String Username = "";
    private static String Password = "" ;
    private static String host = "";
    private static String DatabaseID = "";
    public static String url = "jdbc:mysql://"+ host + "/"+DatabaseID+"?useSSL=false";
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
        url = "jdbc:h2:mem:teamC_josh;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=MYSQL;DATABASE_TO_UPPER=false";
        Username = "sa";
        Password ="";
        return true;
    }
    public static boolean ProdMode(){
        DatabaseID = "teamC_Josh";
        url = "jdbc:mysql://"+ host + "/"+DatabaseID+"?useSSL=false";
        return true;
    };
}