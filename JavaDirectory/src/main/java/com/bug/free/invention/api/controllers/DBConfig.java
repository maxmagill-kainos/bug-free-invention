package com.bug.free.invention.api.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

    private static final String Username = "";
    private static final String Password = "" ;
    private static final String host = "";

    public static Connection getConnection() throws SQLException {
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://"+ host + "/teamCteam_Josh?useSSL=false", Username, Password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
