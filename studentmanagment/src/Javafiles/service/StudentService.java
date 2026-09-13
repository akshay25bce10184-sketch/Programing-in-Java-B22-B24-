package Javafiles.service;

import Javafiles.model.student;
import Javafiles.util.InputValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {

    // Standard student record file, seeded with the course roster
    private static final String CSV_FILE = "students.csv";
    private static final String CSV_HEADER = "studentId,name,rollNumber,course,semester";

    private ArrayList<student> students;

    public StudentService() {
        students = new ArrayList<>();
        loadStudentsFromFile();
    }

    // Load the standard record from students.csv into memory
    private void loadStudentsFromFile() {

        java.io.File file = new java.io.File(CSV_FILE);

        if (!file.exists()) {
            // No roster file yet: start empty and create the header
            saveStudentsToFile();
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {

                if (firstLine) {
                    firstLine = false;
                    if (line.trim().equalsIgnoreCase(CSV_HEADER)) {
                        continue; // skip header row
                    }
                }

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",", -1);

                if (parts.length >= 5) {

                    String studentId = parts[0].trim();
                    String name = parts[1].trim();
                    String rollNumber = parts[2].trim();
                    String course = parts[3].trim();
                    int semester;

                    try {
                        semester = Integer.parseInt(parts[4].trim());
                    } catch (NumberFormatException e) {
                        semester = 1;
                    }

                    students.add(new student(studentId, name, rollNumber, course, semester));
                }
            }

        } catch (IOException e) {
            System.out.println("Warning: could not read " + CSV_FILE + " (" + e.getMessage() + ")");
        }
    }

    // Write the current in-memory roster back out to students.csv
    private void saveStudentsToFile() {

        try (FileWriter writer = new FileWriter(CSV_FILE)) {

            writer.write(CSV_HEADER + System.lineSeparator());

            for (student s : students) {

                writer.write(
                        s.getStudentId() + "," +
                                s.getName() + "," +
                                s.getRollNumber() + "," +
                                s.getCourse() + "," +
                                s.getSemester() +
                                System.lineSeparator());
            }

        } catch (IOException e) {
            System.out.println("Warning: could not save " + CSV_FILE + " (" + e.getMessage() + ")");
        }
    }

    // Adding a student requires an authorized (logged-in) user
    public void addStudent(Scanner scanner, AuthService authService) {

        if (!authService.isLoggedIn()) {
            System.out.println(
                    "\nAccess denied. You must log in as an authorized user to add a student.");
            return;
        }

        System.out.println("\n========== ADD STUDENT ==========");

        String studentId = InputValidator.readNonEmptyString(
                scanner,
                "Enter Student ID: ");

        if (findStudent(studentId) != null) {
            System.out.println("Student ID already exists.");
            return;
        }

        String name = InputValidator.readNonEmptyString(
                scanner,
                "Enter Name: ");

        String rollNumber = InputValidator.readNonEmptyString(
                scanner,
                "Enter Roll Number: ");

        String course = InputValidator.readNonEmptyString(
                scanner,
                "Enter Course: ");

        int semester = InputValidator.readIntInRange(
                scanner,
                "Enter Semester (1-8): ",
                1,
                8);

        student student = new student(
                studentId,
                name,
                rollNumber,
                course,
                semester);

        students.add(student);
        saveStudentsToFile();

        System.out.println(
                "\nStudent added successfully by " + authService.getCurrentUser() + ".");
    }

    public void viewAllStudents() {

        System.out.println("\n========== ALL STUDENTS ==========");

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (student student : students) {

            System.out.println("----------------------------------");
            System.out.println(student);
        }
    }

    public void searchStudent(Scanner scanner) {

        System.out.println("\n========== SEARCH STUDENT ==========");

        String studentId = InputValidator.readNonEmptyString(
                scanner,
                "Enter Student ID: ");

        student student = findStudent(studentId);

        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println(student);
        }
    }

    // Updating a student now also requires an authorized (logged-in) user
    public void updateStudent(Scanner scanner, AuthService authService) {

        if (!authService.isLoggedIn()) {
            System.out.println(
                    "\nAccess denied. You must log in as an authorized user to update a student.");
            return;
        }

        System.out.println("\n========== UPDATE STUDENT ==========");

        String studentId = InputValidator.readNonEmptyString(
                scanner,
                "Enter Student ID: ");

        student student = findStudent(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        String name = InputValidator.readNonEmptyString(
                scanner,
                "Enter New Name: ");

        String rollNumber = InputValidator.readNonEmptyString(
                scanner,
                "Enter New Roll Number: ");

        String course = InputValidator.readNonEmptyString(
                scanner,
                "Enter New Course: ");

        int semester = InputValidator.readIntInRange(
                scanner,
                "Enter New Semester (1-8): ",
                1,
                8);

        student.setName(name);
        student.setRollNumber(rollNumber);
        student.setCourse(course);
        student.setSemester(semester);

        saveStudentsToFile();

        System.out.println(
                "Student information updated successfully by " + authService.getCurrentUser() + ".");
    }

    // Removing a student now also requires an authorized (logged-in) user
    public void removeStudent(Scanner scanner, AuthService authService) {

        if (!authService.isLoggedIn()) {
            System.out.println(
                    "\nAccess denied. You must log in as an authorized user to remove a student.");
            return;
        }

        System.out.println("\n========== REMOVE STUDENT ==========");

        String studentId = InputValidator.readNonEmptyString(
                scanner,
                "Enter Student ID: ");

        student student = findStudent(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        students.remove(student);
        saveStudentsToFile();

        System.out.println(
                "Student removed successfully by " + authService.getCurrentUser() + ".");
    }

    public student findStudent(String studentId) {

        for (student student : students) {

            if (student.getStudentId()
                    .equalsIgnoreCase(studentId)) {

                return student;
            }
        }

        return null;
    }

    public boolean studentExists(String studentId) {
        return findStudent(studentId) != null;
    }

    public void studentMenu(Scanner scanner, AuthService authService) {

        boolean back = false;

        while (!back) {

            System.out.println(
                    "\n========== STUDENT MANAGEMENT ==========");

            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Remove Student");
            System.out.println("6. Back");

            int choice = InputValidator.readInt(
                    scanner,
                    "Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent(scanner, authService);
                    break;

                case 2:
                    viewAllStudents();
                    break;

                case 3:
                    searchStudent(scanner);
                    break;

                case 4:
                    updateStudent(scanner, authService);
                    break;

                case 5:
                    removeStudent(scanner, authService);
                    break;

                case 6:
                    back = true;
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please select 1-6.");
            }
        }
    }
}