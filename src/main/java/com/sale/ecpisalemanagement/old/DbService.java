package com.sale.ecpisalemanagement.old;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbService {

    private static Connection connection;
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/sale","root","");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return connection;
    }
}
