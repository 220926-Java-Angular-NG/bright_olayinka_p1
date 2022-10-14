package com.brightola.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {


    private static Connection conn;
    private static Properties properties;


    // we are creating a private constructor because we should npt be able to
    // make another instance of this class
    private ConnectionManager(){

    }



    // create my connection

    public static Connection getConnection() throws SQLException {

        if(properties == null){
            properties = loadProperties();
        }

        if(conn == null || conn.isClosed()){
            conn = DriverManager.getConnection(properties.getProperty("url"),
                    properties.getProperty("username"),
                    properties.getProperty("password")
            );
        }

        return conn;
    }




    // this method is finding my properties file and returning it to me

    private static Properties loadProperties(){

        Properties properties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/jdbc.properties");
            properties.load(fileInputStream);

        }catch(IOException fnfException){
            System.out.println(fnfException.getMessage());
        }
        return properties;

    }



}