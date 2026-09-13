# Project Statement

## Smart Student Attendance & Performance Management System

**Course:** CSE2006 – Programming in Java  
**Student:** Akshay Pratap Singh  
**Registration Number:** 25BCE10184  
**Slot:** B22 + B24  

---

## 1. Problem Statement

Educational institutions need to maintain accurate and organized records of student information, attendance, and academic performance.

Traditional or manual approaches to managing these records can become time-consuming and may lead to:

- Duplicate student records
- Incorrect attendance calculations
- Difficulty identifying students with attendance shortages
- Repeated manual calculation of academic performance
- Difficulty maintaining consistent student information
- Increased effort when preparing academic reports
- Errors caused by invalid or incomplete data entry

The **Smart Student Attendance & Performance Management System** is proposed as a Java-based application to address these challenges.

The system provides a centralized and structured environment in which authorized users can manage student information, record attendance, maintain academic performance information, and generate consolidated student reports.

The project demonstrates how Java programming concepts can be applied to solve a practical academic management problem.

---

## 2. Project Scope

The scope of the project covers the development of a modular, menu-driven Java application for basic academic record management.

### 2.1 Student Management

The system provides functionality to:

- Add student records
- View student records
- Search for students
- Update student information
- Delete student records
- Detect duplicate student IDs

Student information includes:

- Student ID
- Name
- Roll Number
- Course
- Semester

### 2.2 Attendance Management

The system provides functionality to:

- Record attendance
- View attendance information
- Calculate attendance percentage
- Identify attendance shortages
- Validate attendance-related input

The system uses a 75% attendance threshold for identifying attendance shortages.

### 2.3 Performance Management

The system provides functionality to:

- Enter subject-wise marks
- View academic performance
- Validate marks
- Calculate average marks
- Assign grades
- Evaluate overall academic performance

### 2.4 Authentication

The system provides basic user authentication functionality, including:

- User login
- Credential validation
- User registration
- Logout

### 2.5 Report Generation

The system provides a consolidated academic report containing relevant information such as:

- Student details
- Attendance information
- Attendance percentage
- Academic performance
- Average marks
- Overall grade

### 2.6 Data Management

The current implementation uses local CSV-based storage where applicable and in-memory collections for runtime management of attendance and performance information.

---

## 3. Target Users

The primary target users of the system are:

### 3.1 Faculty / Teachers

Faculty members can use the system to:

- Manage student records
- Record attendance
- Review attendance status
- Enter academic marks
- Review student performance
- Generate student reports

### 3.2 Academic Administrators

Administrators can use the system to:

- Manage student information
- Manage application users
- Review academic records
- Generate consolidated reports

### 3.3 Students

The system is primarily designed for faculty and administrative use. Student-oriented access can be introduced as a future enhancement.

---

## 4. High-Level Features

The major features of the system are:

### 🔐 Authentication

- User login
- Credential validation
- User registration
- Logout functionality

### 👨‍🎓 Student Management

- Add student
- View students
- Search student
- Update student
- Delete student
- Duplicate ID validation

### 📊 Attendance Management

- Record attendance
- View attendance
- Calculate attendance percentage
- Detect attendance shortage
- Attendance validation

### 📝 Performance Management

- Enter marks
- View marks
- Calculate average
- Assign grades
- Validate marks

### 📄 Report Generation

- Generate consolidated student reports
- Display attendance status
- Display academic performance
- Display average marks and grades

### ✅ Input Validation

- Numeric validation
- Range validation
- Duplicate record validation
- Invalid input handling
- Authentication validation

---

## 5. Functional Requirements

The system shall provide the following functional capabilities:

### FR-01: User Authentication

The system shall allow authorized users to log in using valid credentials.

### FR-02: User Registration

The system shall allow users to be registered through the authentication module.

### FR-03: Student Creation

The system shall allow authorized users to add new student records.

### FR-04: Student Retrieval

The system shall allow users to view and search existing student records.

### FR-05: Student Modification

The system shall allow authorized users to update existing student information.

### FR-06: Student Deletion

The system shall allow authorized users to remove student records.

### FR-07: Attendance Recording

The system shall allow attendance information to be recorded and viewed.

### FR-08: Attendance Calculation

The system shall calculate student attendance percentages.

### FR-09: Attendance Shortage Detection

The system shall identify students whose attendance falls below the defined threshold.

### FR-10: Performance Recording

The system shall allow subject-wise academic marks to be entered and viewed.

### FR-11: Performance Calculation

The system shall calculate average marks and determine grades.

### FR-12: Report Generation

The system shall generate consolidated academic information for a student.

### FR-13: Input Validation

The system shall validate user input and reject invalid data where applicable.

---

## 6. Non-Functional Requirements

### NFR-01: Usability

The application should provide a clear menu-driven interface that is easy to understand and operate.

### NFR-02: Reliability

The application should handle invalid inputs and common operational errors without unexpected termination.

### NFR-03: Maintainability

The application should use a modular structure that separates models, services, and utility functions.

### NFR-04: Performance

The application should provide responsive operations for small-to-medium academic datasets.

### NFR-05: Portability

The application should run on systems supporting the required Java Development Kit.

### NFR-06: Resource Efficiency

The application should use lightweight local storage and in-memory collections without requiring an external server.

### NFR-07: Security

Sensitive authentication information should not be exposed in the public repository. Production deployment should use secure password storage and stronger access controls.

---

## 7. Application Workflow

The high-level workflow of the application is:

```text
                    ┌───────────────┐
                    │     START     │
                    └───────┬───────┘
                            │
                            ▼
                    ┌───────────────┐
                    │     LOGIN     │
                    └───────┬───────┘
                            │
                  ┌─────────┴─────────┐
                  │                   │
               Invalid              Valid
                  │                   │
                  ▼                   ▼
                Retry            MAIN MENU
                                      │
             ┌────────────────────────┼────────────────────────┐
             │                        │                        │
             ▼                        ▼                        ▼
      Student Management      Attendance Management    Performance Management
             │                        │                        │
       ┌─────┼─────┐            ┌─────┼─────┐            ┌────┼─────┐
       │     │     │            │     │     │            │    │     │
      Add  Search Update       Mark  View Shortage       Add  View  Grade
       │     │     │            │     │     │            │    │     │
       └─────┼─────┘            └─────┼─────┘            └────┼─────┘
             │                        │                        │
             └────────────────────────┼────────────────────────┘
                                      │
                                      ▼
                              REPORT GENERATION
                                      │
                                      ▼
                                LOGOUT / EXIT
