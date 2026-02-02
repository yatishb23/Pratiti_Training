package com.yatish.JDBC;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.yatish.Main;

public class GetConnection {
    static Connection connection;
    static{    
        Properties p = new Properties();
        try (InputStream input =
                     Main.class
                         .getClassLoader()
                         .getResourceAsStream("app.properties")) {

            if (input == null) {
                System.out.println("app.properties not found");
            }

            p.load(input);

            connection = DriverManager.getConnection(
                    p.getProperty("db.url"),
                    p.getProperty("db.user"),
                    p.getProperty("db.password")
            );

            System.out.println("Connected to MySQL .......");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
    
    public static Connection getConneciton() {
        return connection;
    }
}
/* 
    try{
        Properties p=new Properties();
        p.load()=new FileInputStream("src/main/resources/app.properties");
    }

*/