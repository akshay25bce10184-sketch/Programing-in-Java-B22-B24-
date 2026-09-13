package Javafiles.service;

import Javafiles.model.Attendancerecord;
import Javafiles.model.PerformanceRecord;
import Javafiles.model.student;
import Javafiles.util.InputValidator;

import java.util.ArrayList;
import java.util.Scanner;

public class ReportService {

        private final StudentService studentService;
        private final AttendanceService attendanceService;
        private final PerformanceService performanceService;

        public ReportService(
                        StudentService studentService,
                        AttendanceService attendanceService,
                        PerformanceService performanceService) {

                this.studentService = studentService;
                this.attendanceService = attendanceService;
                this.performanceService = performanceService;
        }

        // Generate a full report for one student
        public void generateReport(Scanner scanner) {

                System.out.println("\n========== STUDENT REPORT ==========");

                String studentId = InputValidator.readNonEmptyString(
                                scanner,
                                "Enter Student ID: ");

                student student = studentService.findStudent(studentId);

                if (student == null) {
                        System.out.println("Student not found.");
                        return;
                }

                System.out.println("\n--- Student Details ---");
                System.out.println(student);

                System.out.println("\n--- Attendance ---");

                Attendancerecord attendance = attendanceService.findAttendanceRecord(studentId);

                if (attendance == null) {
                        System.out.println("No attendance record found.");
                } else {
                        System.out.println(attendance);
                }

                System.out.println("\n--- Performance ---");

                ArrayList<PerformanceRecord> records = performanceService.getStudentRecords(studentId);

                if (records.isEmpty()) {
                        System.out.println("No performance records found.");
                } else {

                        for (PerformanceRecord record : records) {
                                System.out.println("----------------------------------");
                                System.out.println(record);
                        }

                        System.out.printf(
                                        "%nAverage Marks : %.2f%n",
                                        performanceService.calculateAverage(studentId));

                        System.out.println(
                                        "Overall Grade : " + performanceService.getOverallGrade(studentId));
                }

                System.out.println("\n=====================================");
        }

        // Report management menu
        public void reportMenu(Scanner scanner) {

                boolean back = false;

                while (!back) {

                        System.out.println(
                                        "\n========== REPORT MENU ==========");

                        System.out.println("1. Generate Student Report");
                        System.out.println("2. Back");

                        int choice = InputValidator.readInt(
                                        scanner,
                                        "Enter your choice: ");

                        switch (choice) {

                                case 1:
                                        generateReport(scanner);
                                        break;

                                case 2:
                                        back = true;
                                        break;

                                default:
                                        System.out.println(
                                                        "Invalid choice. Please select 1-2.");
                        }
                }
        }
}