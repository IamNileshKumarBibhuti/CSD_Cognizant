package com.employee.attendance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/EmployeeAttendanceSystem";
    private static final String USER = "root"; // change to your MySQL user-name
    private static final String PASSWORD = "Bananna@123"; // change to your MySQL password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
