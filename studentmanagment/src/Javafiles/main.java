package Javafiles;

import Javafiles.service.AttendanceService;
import Javafiles.service.AuthService;
import Javafiles.service.PerformanceService;
import Javafiles.service.ReportService;
import Javafiles.service.StudentService;
import Javafiles.util.InputValidator;

import java.util.Scanner;

class Main {

        public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);

                AuthService authService = new AuthService();
                StudentService studentService = new StudentService();
                AttendanceService attendanceService = new AttendanceService();
                PerformanceService performanceService = new PerformanceService();

                ReportService reportService = new ReportService(
                                studentService,
                                attendanceService,
                                performanceService);

                boolean running = true;

                System.out.println(
                                "==============================================");
                System.out.println(
                                " SMART STUDENT ATTENDANCE & PERFORMANCE SYSTEM");
                System.out.println(
                                "==============================================");
                System.out.println(
                                "\nDefault login -> username: admin  password: admin123");

                while (running) {

                        displayMainMenu(authService);

                        int choice = InputValidator.readInt(
                                        scanner,
                                        "Enter your choice: ");

                        try {

                                switch (choice) {

                                        case 1:
                                                studentService.studentMenu(
                                                                scanner,
                                                                authService);
                                                break;

                                        case 2:
                                                attendanceService.attendanceMenu(
                                                                scanner,
                                                                studentService,
                                                                authService);
                                                break;

                                        case 3:
                                                performanceService.performanceMenu(
                                                                scanner,
                                                                studentService,
                                                                authService);
                                                break;

                                        case 4:
                                                reportService.reportMenu(scanner);
                                                break;

                                        case 5:
                                                if (authService.isLoggedIn()) {
                                                        System.out.println(
                                                                        "\nAlready logged in as " +
                                                                                        authService.getCurrentUser()
                                                                                        + ".");
                                                } else {
                                                        authService.login(scanner);
                                                }
                                                break;

                                        case 6:
                                                authService.logout();
                                                break;

                                        case 7:
                                                authService.addAuthorizedUser(scanner);
                                                break;

                                        case 8:
                                                running = false;
                                                System.out.println(
                                                                "\nThank you for using the system.");
                                                break;

                                        default:
                                                System.out.println(
                                                                "\nInvalid choice. Please select 1-8.");
                                }

                        } catch (Exception e) {

                                System.out.println(
                                                "\nError: " + e.getMessage());
                        }
                }

                scanner.close();
        }

        private static void displayMainMenu(AuthService authService) {

                System.out.println(
                                "\n==============================================");
                System.out.println(
                                "                  MAIN MENU");
                System.out.println(
                                "==============================================");

                if (authService.isLoggedIn()) {
                        System.out.println(
                                        "Logged in as: " + authService.getCurrentUser());
                } else {
                        System.out.println(
                                        "Status: Not logged in (adding details requires login)");
                }

                System.out.println(
                                "==============================================");
                System.out.println("1. Student Management");
                System.out.println("2. Attendance Management");
                System.out.println("3. Performance Management");
                System.out.println("4. Generate Student Report");
                System.out.println("5. Login");
                System.out.println("6. Logout");
                System.out.println("7. Register New User (must be logged in)");
                System.out.println("8. Exit");
                System.out.println(
                                "==============================================");
        }
}