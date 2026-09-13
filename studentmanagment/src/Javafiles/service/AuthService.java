package Javafiles.service;

import Javafiles.util.InputValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AuthService {

    // Rough storage: username,password per line in this CSV file
    private static final String CSV_FILE = "users.csv";
    private static final String CSV_HEADER = "username,password";

    private final Map<String, String> authorizedUsers;
    private String currentUser;
    private boolean loggedIn;

    public AuthService() {

        authorizedUsers = new HashMap<>();
        loggedIn = false;
        currentUser = null;

        loadUsersFromFile();
    }

    // Read username,password pairs from the CSV file into memory
    private void loadUsersFromFile() {

        java.io.File file = new java.io.File(CSV_FILE);

        if (!file.exists()) {

            // First run: seed the file with default accounts
            authorizedUsers.put("admin", "admin123");
            authorizedUsers.put("teacher", "teacher123");
            saveUsersToFile();
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

                String[] parts = line.split(",", 2);

                if (parts.length == 2) {
                    authorizedUsers.put(parts[0].trim(), parts[1].trim());
                }
            }

        } catch (IOException e) {
            System.out.println("Warning: could not read " + CSV_FILE + " (" + e.getMessage() + ")");
        }
    }

    // Write the full in-memory user map back out to the CSV file
    private void saveUsersToFile() {

        try (FileWriter writer = new FileWriter(CSV_FILE)) {

            writer.write(CSV_HEADER + System.lineSeparator());

            for (Map.Entry<String, String> entry : authorizedUsers.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + System.lineSeparator());
            }

        } catch (IOException e) {
            System.out.println("Warning: could not save " + CSV_FILE + " (" + e.getMessage() + ")");
        }
    }

    // Prompt for credentials and log the user in if valid
    public boolean login(Scanner scanner) {

        System.out.println("\n========== LOGIN ==========");

        String username = InputValidator.readNonEmptyString(
                scanner,
                "Username: ");

        String password = InputValidator.readNonEmptyString(
                scanner,
                "Password: ");

        if (authorizedUsers.containsKey(username) &&
                authorizedUsers.get(username).equals(password)) {

            loggedIn = true;
            currentUser = username;

            System.out.println("Login successful. Welcome, " + username + "!");
            return true;
        }

        System.out.println("Invalid username or password.");
        return false;
    }

    public void logout() {

        if (loggedIn) {
            System.out.println("Goodbye, " + currentUser + ".");
        } else {
            System.out.println("No user is currently logged in.");
        }

        loggedIn = false;
        currentUser = null;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    // Let an already-logged-in user register another authorized account,
    // saved straight to the CSV file
    public void addAuthorizedUser(Scanner scanner) {

        if (!loggedIn) {
            System.out.println(
                    "\nYou must be logged in to register a new authorized user.");
            return;
        }

        System.out.println("\n========== REGISTER NEW USER ==========");

        String username = InputValidator.readNonEmptyString(
                scanner,
                "New Username: ");

        if (authorizedUsers.containsKey(username)) {
            System.out.println("That username already exists.");
            return;
        }

        String password = InputValidator.readNonEmptyString(
                scanner,
                "New Password: ");

        authorizedUsers.put(username, password);
        saveUsersToFile();

        System.out.println("New authorized user added and saved to " + CSV_FILE + ".");
    }
}