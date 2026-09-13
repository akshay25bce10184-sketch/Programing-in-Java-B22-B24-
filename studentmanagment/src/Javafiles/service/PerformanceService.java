package Javafiles.service;

import Javafiles.model.PerformanceRecord;
import Javafiles.model.student;
import Javafiles.util.InputValidator;
import java.util.ArrayList;
import java.util.Scanner;

public class PerformanceService {

    private ArrayList<PerformanceRecord> performanceRecords;

    public PerformanceService() {
        performanceRecords = new ArrayList<>();
    }

    // Entering marks now requires an authorized (logged-in) user
    public void enterMarks(
            Scanner scanner,
            StudentService studentService,
            AuthService authService) {

        if (!authService.isLoggedIn()) {
            System.out.println(
                    "\nAccess denied. You must log in as an authorized user to enter marks.");
            return;
        }

        System.out.println("\n========== ENTER PERFORMANCE ==========");

        String studentId = InputValidator.readNonEmptyString(
                scanner,
                "Enter Student ID: ");

        student student = studentService.findStudent(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        String subject = InputValidator.readNonEmptyString(
                scanner,
                "Enter Subject: ");

        double marks = InputValidator.readDoubleInRange(
                scanner,
                "Enter Marks (0-100): ",
                0,
                100);

        PerformanceRecord record = new PerformanceRecord(
                studentId,
                subject,
                marks);

        performanceRecords.add(record);

        System.out.println(
                "Performance record added successfully by " + authService.getCurrentUser() + ".");

        System.out.println(
                "Grade: " + record.getGrade());
    }

    public void viewStudentPerformance(
            Scanner scanner) {

        System.out.println(
                "\n========== STUDENT PERFORMANCE ==========");

        String studentId = InputValidator.readNonEmptyString(
                scanner,
                "Enter Student ID: ");

        ArrayList<PerformanceRecord> records = getStudentRecords(studentId);

        if (records.isEmpty()) {

            System.out.println(
                    "No performance records found.");
            return;
        }

        for (PerformanceRecord record : records) {

            System.out.println("----------------------------------");
            System.out.println(record);
        }
    }

    public ArrayList<PerformanceRecord> getStudentRecords(String studentId) {

        ArrayList<PerformanceRecord> records = new ArrayList<>();

        for (PerformanceRecord record : performanceRecords) {

            if (record.getStudentId()
                    .equalsIgnoreCase(studentId)) {

                records.add(record);
            }
        }

        return records;
    }

    public double calculateAverage(String studentId) {

        ArrayList<PerformanceRecord> records = getStudentRecords(studentId);

        if (records.isEmpty()) {
            return 0.0;
        }

        double total = 0;

        for (PerformanceRecord record : records) {
            total += record.getMarks();
        }

        return total / records.size();
    }

    public String getOverallGrade(String studentId) {

        double average = calculateAverage(studentId);

        if (average >= 90) {
            return "A+";
        } else if (average >= 80) {
            return "A";
        } else if (average >= 70) {
            return "B+";
        } else if (average >= 60) {
            return "B";
        } else if (average >= 50) {
            return "C";
        } else if (average >= 40) {
            return "D";
        } else {
            return "F";
        }
    }

    public void displayAverage(
            Scanner scanner) {

        String studentId = InputValidator.readNonEmptyString(
                scanner,
                "Enter Student ID: ");

        ArrayList<PerformanceRecord> records = getStudentRecords(studentId);

        if (records.isEmpty()) {

            System.out.println(
                    "No performance records found.");
            return;
        }

        double average = calculateAverage(studentId);

        System.out.printf(
                "Average Marks: %.2f%n",
                average);

        System.out.println(
                "Overall Grade: " +
                        getOverallGrade(studentId));
    }

    public void performanceMenu(
            Scanner scanner,
            StudentService studentService,
            AuthService authService) {

        boolean back = false;

        while (!back) {

            System.out.println(
                    "\n========== PERFORMANCE MANAGEMENT ==========");

            System.out.println("1. Enter Marks");
            System.out.println("2. View Student Performance");
            System.out.println("3. Calculate Average & Grade");
            System.out.println("4. Back");

            int choice = InputValidator.readInt(
                    scanner,
                    "Enter your choice: ");

            switch (choice) {

                case 1:
                    enterMarks(
                            scanner,
                            studentService,
                            authService);
                    break;

                case 2:
                    viewStudentPerformance(scanner);
                    break;

                case 3:
                    displayAverage(scanner);
                    break;

                case 4:
                    back = true;
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please select 1-4.");
            }
        }
    }
}