package com.bug.free.invention.api.controllers;
import org.springframework.beans.factory.annotation.Value;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConfig {

    private static String Username;
    private static String Password;
    private static String host;
    private static String DatabaseID;
    public DBConfig( @Value("${spring.main.username}") String Username,
                     @Value("${spring.main.password}") String Password,
                     @Value("${spring.main.host}") String host,
                     @Value("${spring.main.DatabaseID}") String DatabaseID) {
        this.Username = Username;
        this.Password = Password;
        this.host = host;
        this.DatabaseID = DatabaseID;
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
        DatabaseID = "${spring.main.DatabaseID}";
        return true;
    }
    public static boolean ProdMode(){
        DatabaseID = "${spring.main.DatabaseID}";
        return true;
    }
}