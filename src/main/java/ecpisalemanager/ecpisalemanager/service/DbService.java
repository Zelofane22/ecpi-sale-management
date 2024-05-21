package ecpisalemanager.ecpisalemanager.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbService {

    private static Connection connection;

    static {
        try{
            Class.forName("com.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/sale_manager","root","");

        }
        catch (Exception exception) {
            System.out.println(exception.getMessage()) ;
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
