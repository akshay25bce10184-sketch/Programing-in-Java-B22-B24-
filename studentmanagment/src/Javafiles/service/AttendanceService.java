package Javafiles.service;

import Javafiles.model.Attendancerecord;
import Javafiles.model.student;
import Javafiles.util.InputValidator;

import java.util.ArrayList;
import java.util.Scanner;

public class AttendanceService {

    private final ArrayList<Attendancerecord> attendanceRecords;

    public AttendanceService() {
        attendanceRecords = new ArrayList<>();
    }

    // Marking/updating attendance now requires an authorized (logged-in) user
    public void markAttendance(Scanner scanner, StudentService studentService, AuthService authService) {

        if (!authService.isLoggedIn()) {
            System.out.println(
                    "\nAccess denied. You must log in as an authorized user to mark attendance.");
            return;
        }

        System.out.println("\n========== MARK ATTENDANCE ==========");

        String studentId = InputValidator.readNonEmptyString(
                scanner,
                "Enter Student ID: ");

        student student = studentService.findStudent(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        int totalClasses = InputValidator.readPositiveInt(
                scanner,
                "Enter Total Classes: ");

        int attendedClasses = InputValidator.readIntInRange(
                scanner,
                "Enter Attended Classes: ",
                0,
                totalClasses);

        Attendancerecord existingRecord = findAttendanceRecord(studentId);

        if (existingRecord == null) {

            Attendancerecord record = new Attendancerecord(
                    studentId,
                    totalClasses,
                    attendedClasses);

            attendanceRecords.add(record);

        } else {

            existingRecord.setTotalClasses(totalClasses);
            existingRecord.setAttendedClasses(attendedClasses);
        }

        System.out.println(
                "Attendance recorded successfully by " + authService.getCurrentUser() + ".");
    }

    // View attendance of one student
    public void viewAttendance(Scanner scanner) {

        System.out.println("\n========== VIEW ATTENDANCE ==========");

        String studentId = InputValidator.readNonEmptyString(
                scanner,
                "Enter Student ID: ");

        Attendancerecord record = findAttendanceRecord(studentId);

        if (record == null) {
            System.out.println("Attendance record not found.");
        } else {
            System.out.println(record);
        }
    }

    // Check attendance shortage
    public void checkShortage(Scanner scanner) {

        System.out.println("\n========== ATTENDANCE STATUS ==========");

        String studentId = InputValidator.readNonEmptyString(
                scanner,
                "Enter Student ID: ");

        Attendancerecord record = findAttendanceRecord(studentId);

        if (record == null) {
            System.out.println("Attendance record not found.");
            return;
        }

        double percentage = record.getAttendancePercentage();

        System.out.printf(
                "Attendance: %.2f%%%n",
                percentage);

        if (record.isShortage()) {
            System.out.println(
                    "Status: Attendance Shortage");
        } else {
            System.out.println(
                    "Status: Attendance Satisfactory");
        }
    }

    // Find attendance record using student ID
    public Attendancerecord findAttendanceRecord(
            String studentId) {

        for (Attendancerecord record : attendanceRecords) {

            if (record.getStudentId()
                    .equalsIgnoreCase(studentId)) {

                return record;
            }
        }

        return null;
    }

    // View all attendance records
    public void viewAllAttendance() {

        System.out.println(
                "\n========== ALL ATTENDANCE RECORDS ==========");

        if (attendanceRecords.isEmpty()) {
            System.out.println(
                    "No attendance records available.");
            return;
        }

        for (Attendancerecord record : attendanceRecords) {

            System.out.println(
                    "----------------------------------");

            System.out.println(record);
        }
    }

    // Attendance management menu
    public void attendanceMenu(
            Scanner scanner,
            StudentService studentService,
            AuthService authService) {

        boolean back = false;

        while (!back) {

            System.out.println(
                    "\n========== ATTENDANCE MANAGEMENT ==========");

            System.out.println("1. Mark/Update Attendance");
            System.out.println("2. View Student Attendance");
            System.out.println("3. View All Attendance");
            System.out.println("4. Check Attendance Shortage");
            System.out.println("5. Back");

            int choice = InputValidator.readInt(
                    scanner,
                    "Enter your choice: ");

            switch (choice) {

                case 1:
                    markAttendance(
                            scanner,
                            studentService,
                            authService);
                    break;

                case 2:
                    viewAttendance(scanner);
                    break;

                case 3:
                    viewAllAttendance();
                    break;

                case 4:
                    checkShortage(scanner);
                    break;

                case 5:
                    back = true;
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please select 1-5.");
            }
        }
    }
}