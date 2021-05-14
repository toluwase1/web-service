package com.example.Web_Service.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

// final so the class cannot be inherited
public final class DbUtils {
    private static String driver, url, user, password;

    //private constructor so they cant be instantiated
    private DbUtils() {
    }

    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        driver = resourceBundle.getString("jdbc.driver");
        url = resourceBundle.getString("jdbc.url");
        user = resourceBundle.getString("jdbc.user");
        password = resourceBundle.getString("jdbc.password");
    }

    public static Connection getConnection () throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return DriverManager.getConnection(url, user, password);
    }
}

