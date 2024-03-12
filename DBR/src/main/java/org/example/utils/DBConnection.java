package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;
    private  static final  String DATABASE_URL= DBNativeSQLQuries.DATABASE_URL;
    private static  final  String USER =DBNativeSQLQuries.USER;

    private  static  final  String PASSWORD = DBNativeSQLQuries.PASSWORD;
    private  static  final  String CLASS_NAME = DBNativeSQLQuries.CLASS_NAME;

    public  static Connection getDBConnection()  {
        try {
            Class.forName(CLASS_NAME);
            connection = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
        }catch (SQLException | ClassNotFoundException exception){
            exception.getMessage();
        }
        return  connection;
    }
}
