package com.employee.attendance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AttendanceManagement {
    private Scanner scanner = new Scanner(System.in);

    public void recordAttendance() {
        try (Connection connection = DatabaseUtil.getConnection()) {
            System.out.print("Enter employee ID: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Enter date (YYYY-MM-DD): ");
            String date = scanner.nextLine();
            System.out.print("Enter status (present/absent): ");
            String status = scanner.nextLine();

            String sql = "INSERT INTO Attendance (employee_id, date, status) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, employeeId);
            statement.setString(2, date);
            statement.setString(3, status);
            statement.executeUpdate();

            System.out.println("Attendance recorded successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAttendance() {
        try (Connection connection = DatabaseUtil.getConnection()) {
            System.out.print("Enter attendance ID: ");
            int attendanceId = scanner.nextInt();
            scanner.nextLine(); 

            String sql = "SELECT * FROM Attendance WHERE attendance_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, attendanceId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Attendance ID: " + resultSet.getInt("attendance_id"));
                System.out.println("Employee ID: " + resultSet.getInt("employee_id"));
                System.out.println("Date: " + resultSet.getDate("date"));
                System.out.println("Status: " + resultSet.getString("status"));
            } else {
                System.out.println("Attendance record not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAttendance() {
        try (Connection connection = DatabaseUtil.getConnection()) {
            System.out.print("Enter attendance ID: ");
            int attendanceId = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Enter new status (present/absent): ");
            String status = scanner.nextLine();

            String sql = "UPDATE Attendance SET status = ? WHERE attendance_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, status);
            statement.setInt(2, attendanceId);
            statement.executeUpdate();

            System.out.println("Attendance updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAttendance() {
        try (Connection connection = DatabaseUtil.getConnection()) {
            System.out.print("Enter attendance ID: ");
            int attendanceId = scanner.nextInt();
            scanner.nextLine(); 

            String sql = "DELETE FROM Attendance WHERE attendance_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, attendanceId);
            statement.executeUpdate();

            System.out.println("Attendance record deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
