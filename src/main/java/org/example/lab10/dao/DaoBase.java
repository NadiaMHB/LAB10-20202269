package org.example.lab10.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DaoBase {
    public Connection getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        String username = "root";
        String password = "root";
        String database = "lab7";
        String url = "jdbc:mysql://localhost:3306/" + database;

        //return DriverManager.getConnection(url, username, password);
        return DriverManager.getConnection("jdbc:mysql://34.75.95.213:3306/" + database, "root", "root");
    }
}
