package com.sale.ecpisalemanagement.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbService {

    private static Connection connection;

    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sale","root","");

        }
        catch (Exception exception) {
            System.out.println(exception.getMessage()) ;
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
