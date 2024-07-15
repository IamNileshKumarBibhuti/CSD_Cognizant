package com.employee.attendance;

import java.util.Scanner;

public class EmployeeAttendanceSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeManagement employeeManagement = new EmployeeManagement();
    private static AttendanceManagement attendanceManagement = new AttendanceManagement();
    private static AttendanceReport attendanceReport = new AttendanceReport();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Employee Attendance System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Record Attendance");
            System.out.println("6. View Attendance");
            System.out.println("7. Update Attendance");
            System.out.println("8. Delete Attendance");
            System.out.println("9. Generate Monthly Attendance Report");
            System.out.println("10. Generate Daily Attendance Report");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    employeeManagement.addEmployee();
                    break;
                case 2:
                    employeeManagement.viewEmployee();
                    break;
                case 3:
                    employeeManagement.updateEmployee();
                    break;
                case 4:
                    employeeManagement.deleteEmployee();
                    break;
                case 5:
                    attendanceManagement.recordAttendance();
                    break;
                case 6:
                    attendanceManagement.viewAttendance();
                    break;
                case 7:
                    attendanceManagement.updateAttendance();
                    break;
                case 8:
                    attendanceManagement.deleteAttendance();
                    break;
                case 9:
                    attendanceReport.generateMonthlyReport();
                    break;
                case 10:
                    attendanceReport.generateDailyReport();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
