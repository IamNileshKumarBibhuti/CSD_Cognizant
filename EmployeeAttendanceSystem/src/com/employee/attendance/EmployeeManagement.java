package com.employee.attendance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeManagement {
    private Scanner scanner = new Scanner(System.in);

    public void addEmployee() {
        try (Connection connection = DatabaseUtil.getConnection()) {
            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();
            System.out.print("Enter department: ");
            String department = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Enter phone number: ");
            String phoneNumber = scanner.nextLine();

            String sql = "INSERT INTO Employee (name, department, email, phone_number) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, department);
            statement.setString(3, email);
            statement.setString(4, phoneNumber);
            statement.executeUpdate();

            System.out.println("Employee added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewEmployee() {
        try (Connection connection = DatabaseUtil.getConnection()) {
            System.out.print("Enter employee ID: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine(); // consume newline

            String sql = "SELECT * FROM Employee WHERE employee_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, employeeId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Employee ID: " + resultSet.getInt("employee_id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Department: " + resultSet.getString("department"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Phone Number: " + resultSet.getString("phone_number"));
            } else {
                System.out.println("Employee not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee() {
        try (Connection connection = DatabaseUtil.getConnection()) {
            System.out.print("Enter employee ID: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new department: ");
            String department = scanner.nextLine();
            System.out.print("Enter new email: ");
            String email = scanner.nextLine();
            System.out.print("Enter new phone number: ");
            String phoneNumber = scanner.nextLine();

            String sql = "UPDATE Employee SET name = ?, department = ?, email = ?, phone_number = ? WHERE employee_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, department);
            statement.setString(3, email);
            statement.setString(4, phoneNumber);
            statement.setInt(5, employeeId);
            statement.executeUpdate();

            System.out.println("Employee updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee() {
        try (Connection connection = DatabaseUtil.getConnection()) {
            System.out.print("Enter employee ID: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine(); // consume newline

            String sql = "DELETE FROM Employee WHERE employee_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, employeeId);
            statement.executeUpdate();

            System.out.println("Employee deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
