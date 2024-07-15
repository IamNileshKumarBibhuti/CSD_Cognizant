package com.employee.attendance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AttendanceReport {
    private Scanner scanner = new Scanner(System.in);

    public void generateMonthlyReport() {
        try (Connection connection = DatabaseUtil.getConnection()) {
            System.out.print("Enter employee ID: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter month (MM): ");
            String month = scanner.nextLine();
            System.out.print("Enter year (YYYY): ");
            String year = scanner.nextLine();

            String sql = "SELECT * FROM Attendance WHERE employee_id = ? AND DATE_FORMAT(date, '%Y-%m') = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, employeeId);
            statement.setString(2, year + "-" + month);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("Attendance report for Employee ID: " + employeeId);
            while (resultSet.next()) {
                System.out.println("Date: " + resultSet.getDate("date") + " | Status: " + resultSet.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void generateDailyReport() {
        try (Connection connection = DatabaseUtil.getConnection()) {
            System.out.print("Enter date (YYYY-MM-DD): ");
            String date = scanner.nextLine();

            String sql = "SELECT * FROM Attendance WHERE date = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, date);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("Attendance report for Date: " + date);
            while (resultSet.next()) {
                System.out.println("Employee ID: " + resultSet.getInt("employee_id") + " | Status: " + resultSet.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
