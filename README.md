# 🎓 Smart Student Attendance & Performance Management System

<p align="center">
  <strong>A Modular Java-Based Academic Management System</strong>
</p>

<p align="center">
  Manage student records, attendance, academic performance, authentication, and consolidated reports through a structured Java application.
</p>

<p align="center">

![Java](https://img.shields.io/badge/Java-8%2B-orange?style=for-the-badge&logo=openjdk)
![Course](https://img.shields.io/badge/Course-CSE2006-blue?style=for-the-badge)
![Architecture](https://img.shields.io/badge/Architecture-Layered-green?style=for-the-badge)
![Storage](https://img.shields.io/badge/Storage-CSV-yellow?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-purple?style=for-the-badge)

</p>

---

# 📌 Table of Contents

- [Project Overview](#-project-overview)
- [Problem Statement](#-problem-statement)
- [Objectives](#-objectives)
- [Key Features](#-key-features)
- [Functional Modules](#-functional-modules)
- [Technology Stack](#-technology-stack)
- [Java Concepts Demonstrated](#-java-concepts-demonstrated)
- [System Architecture](#-system-architecture)
- [Application Workflow](#-application-workflow)
- [Project Structure](#-project-structure)
- [Data Management](#-data-management)
- [Attendance Management](#-attendance-management)
- [Performance Management](#-performance-management)
- [Authentication & Security](#-authentication--security)
- [Prerequisites](#-prerequisites)
- [Installation](#-installation)
- [Running the Application](#-running-the-application)
- [Testing](#-testing)
- [Validation & Error Handling](#-validation--error-handling)
- [Non-Functional Requirements](#-non-functional-requirements)
- [Design Decisions](#-design-decisions)
- [Current Limitations](#-current-limitations)
- [Future Enhancements](#-future-enhancements)
- [CSE2006 Syllabus Mapping](#-cse2006-syllabus-mapping)
- [Documentation](#-documentation)
- [Screenshots](#-screenshots)
- [Repository & Git Guidelines](#-repository--git-guidelines)
- [Contributing](#-contributing)
- [Author](#-author)
- [Acknowledgements](#-acknowledgements)
- [License](#-license)

---

# 📖 Project Overview

The **Smart Student Attendance & Performance Management System** is a Java-based, menu-driven academic management application developed as part of the **CSE2006 – Programming in Java** course.

The application provides a centralized system for managing important academic information such as:

- Student records
- Attendance
- Academic performance
- User authentication
- Attendance shortage detection
- Grade calculation
- Consolidated student reports

The project is designed using a modular architecture with separate model, service, utility, and application-control responsibilities.

It demonstrates the practical application of Java programming concepts to a real-world academic management problem.

---

# ❗ Problem Statement

Educational institutions need to maintain accurate student information, attendance records, and academic performance data.

Manual management of these records can result in:

- Duplicate student records
- Incorrect attendance calculations
- Difficulty identifying attendance shortages
- Repeated manual calculation of marks and grades
- Difficulty maintaining organized academic information
- Increased effort in generating student reports
- Input validation problems

The proposed system addresses these issues by providing a structured Java application that allows authorized users to manage student information, attendance, performance, and reports through a unified interface.

---

# 🎯 Objectives

The primary objectives of the project are:

1. Develop a practical Java-based academic management application.
2. Implement CRUD operations for student records.
3. Maintain and calculate student attendance.
4. Identify students with attendance shortages.
5. Manage subject-wise academic performance.
6. Calculate average marks and grades automatically.
7. Implement user authentication.
8. Validate user input and application data.
9. Generate consolidated student reports.
10. Demonstrate Object-Oriented Programming principles.
11. Demonstrate Java Collections Framework.
12. Demonstrate Java File I/O.
13. Apply modular programming and package organization.
14. Provide a foundation for future database and security enhancements.

---

# ✨ Key Features

## 🔐 Authentication

- User login
- Credential validation
- User registration
- Logout functionality
- Controlled access to application operations

## 👨‍🎓 Student Management

- Add student
- View students
- Search student
- Update student details
- Delete student
- Duplicate student ID detection

Student information includes:

- Student ID
- Name
- Roll Number
- Course
- Semester

## 📊 Attendance Management

- Record attendance
- View attendance information
- Calculate attendance percentage
- Identify attendance shortages
- Validate attendance input
- Apply attendance threshold

## 📝 Performance Management

- Enter subject-wise marks
- View academic performance
- Validate marks
- Calculate average marks
- Automatically assign grades
- Evaluate overall academic performance

## 📄 Report Generation

The reporting module combines student information, attendance information, and performance information into a consolidated academic report.

Reports may include:

- Student details
- Attendance percentage
- Attendance status
- Subject-wise marks
- Average marks
- Overall grade

## ✅ Input Validation

The application validates user input to reduce invalid data and common runtime errors.

Examples include:

- Invalid numeric input
- Invalid marks
- Invalid attendance values
- Duplicate student IDs
- Invalid student searches
- Invalid authentication details

---

# 🧩 Functional Modules

| Module | Responsibility |
|---|---|
| 🔐 Authentication | Login, registration and user validation |
| 👨‍🎓 Student Management | Student CRUD operations |
| 📊 Attendance Management | Attendance recording and analysis |
| 📝 Performance Management | Marks, averages and grades |
| 📄 Report Generation | Consolidated academic reports |
| ✅ Input Validation | User input validation |

The project satisfies the requirement for multiple meaningful functional modules through separate application services.

---

# 🛠️ Technology Stack

| Technology | Purpose |
|---|---|
| **Java** | Primary programming language |
| **Object-Oriented Programming** | Application and domain design |
| **ArrayList** | In-memory collection management |
| **HashMap** | Key-value data management |
| **Scanner** | Console input |
| **BufferedReader** | Reading text/CSV files |
| **FileWriter** | Writing text/CSV files |
| **Exception Handling** | Controlled error handling |
| **Git** | Version control |
| **GitHub** | Repository hosting |

---

# ☕ Java Concepts Demonstrated

The project applies concepts covered in the CSE2006 Programming in Java curriculum.

## Core Java

- Variables
- Data types
- Operators
- Conditional statements
- Loops
- Methods
- Console input/output

## Object-Oriented Programming

- Classes
- Objects
- Constructors
- Encapsulation
- Methods
- Access modifiers
- Packages
- Object interaction

## Exception Handling

- Input validation
- Invalid data handling
- Runtime error handling
- Controlled error messages

## Collections Framework

- `ArrayList`
- `HashMap`
- Collection-based record management

## File I/O

- File reading
- File writing
- `BufferedReader`
- `FileWriter`
- CSV-based storage

## Modular Programming

- Model layer
- Service layer
- Utility layer
- Application/main layer

---

# 🏗️ System Architecture

The project follows a simple layered architecture.

```text
                         ┌─────────────────────────┐
                         │        Main.java        │
                         │   Console / Menu Layer  │
                         └────────────┬────────────┘
                                      │
                                      ▼
                         ┌─────────────────────────┐
                         │      Service Layer      │
                         ├─────────────────────────┤
                         │ AuthService              │
                         │ StudentService           │
                         │ AttendanceService        │
                         │ PerformanceService       │
                         │ ReportService            │
                         └────────────┬────────────┘
                                      │
                                      ▼
                         ┌─────────────────────────┐
                         │       Model Layer       │
                         ├─────────────────────────┤
                         │ Student                 │
                         │ AttendanceRecord        │
                         │ PerformanceRecord       │
                         └────────────┬────────────┘
                                      │
                                      ▼
                         ┌─────────────────────────┐
                         │      Utility Layer      │
                         │     InputValidator      │
                         └────────────┬────────────┘
                                      │
                                      ▼
                         ┌─────────────────────────┐
                         │      File Storage        │
                         │        CSV Files        │
                         └─────────────────────────┘
```

---

# 🔄 Application Workflow

```text
START
  │
  ▼
LOGIN
  │
  ├── Invalid Credentials ──► Retry
  │
  ▼
MAIN MENU
  │
  ├── Student Management
  │       ├── Add Student
  │       ├── View Students
  │       ├── Search Student
  │       ├── Update Student
  │       └── Delete Student
  │
  ├── Attendance Management
  │       ├── Record Attendance
  │       ├── View Attendance
  │       └── Check Shortage
  │
  ├── Performance Management
  │       ├── Enter Marks
  │       ├── View Performance
  │       └── Calculate Grade
  │
  ├── Report Generation
  │       └── Generate Student Report
  │
  ├── User Management
  │       └── Register User
  │
  ├── Logout
  │
  └── Exit
```

---

# 📁 Project Structure

```text
Programing-in-Java-B22-B24-/
│
├── studentmanagment/
│   │
│   └── src/
│       │
│       └── Javafiles/
│           │
│           ├── model/
│           │   ├── student.java
│           │   ├── Attendancerecord.java
│           │   └── PerformanceRecord.java
│           │
│           ├── service/
│           │   ├── StudentService.java
│           │   ├── AttendanceService.java
│           │   ├── PerformanceService.java
│           │   ├── AuthService.java
│           │   └── ReportService.java
│           │
│           ├── util/
│           │   └── InputValidator.java
│           │
│           └── Main.java
│
├── docs/
│   ├── architecture.png
│   ├── workflow.png
│   ├── use-case.png
│   ├── class-diagram.png
│   ├── sequence-diagram.png
│   └── screenshots/
│
├── README.md
├── statement.md
├── PROJECT_REPORT.pdf
├── LICENSE
└── .gitignore
```

> Keep this structure synchronized with the actual repository whenever files are renamed or reorganized.

---

# 💾 Data Management

The current implementation uses local CSV-based storage where applicable.

## Student Data

Example structure:

```text
studentId,name,rollNumber,course,semester
```

## User Data

Example structure:

```text
username,password
```

Attendance and performance information are currently managed by their respective services and may be maintained in memory during application execution.

### Data Persistence Status

| Data | Current Storage |
|---|---|
| Student information | CSV / local storage |
| User information | CSV / local storage |
| Attendance | In-memory |
| Performance | In-memory |
| Reports | Generated from available application data |

---

# 📊 Attendance Management

Attendance percentage is calculated using:

```text
Attendance Percentage =
(Attended Classes / Total Classes) × 100
```

The application uses a **75% threshold** for identifying attendance shortages.

```text
             Attendance Percentage
                      │
                      ▼
              ┌──────────────┐
              │    >= 75%    │
              └──────┬───────┘
                     │
                     ▼
              Satisfactory

              ┌──────────────┐
              │     < 75%    │
              └──────┬───────┘
                     │
                     ▼
             Attendance Shortage
```

---

# 📝 Performance Management

The system calculates average marks using:

```text
Average Marks =
Sum of Subject Marks / Number of Subjects
```

## Grade Structure

| Marks | Grade |
|---:|:---:|
| 90–100 | A+ |
| 80–89 | A |
| 70–79 | B+ |
| 60–69 | B |
| 50–59 | C |
| 40–49 | D |
| 0–39 | F |

---

# 🔐 Authentication & Security

Authentication is provided through the application's user-management functionality.

## Security Principles

The repository should **never contain real passwords, API keys, database credentials, or private tokens**.

Sensitive files should be excluded from version control.

Example `.gitignore` entries:

```gitignore
*.env
*.secret
config.properties
users.csv
```

Instead of committing real credentials, use example/template files such as:

```text
users.example.csv
config.example.properties
```

## Password Security

The current academic implementation uses local authentication data and should not be considered production-grade security.

For a production-ready implementation, password storage should be upgraded to:

- Secure password hashing
- Salted credentials
- Secure configuration
- Strong authentication controls
- Database-backed user management
- Proper authorization

> **Never publish real credentials in this repository or in the README.**

---

# ⚙️ Prerequisites

Before running the project, install:

- **Java JDK 8 or later**
- **Git**
- Java-compatible IDE or terminal

Recommended IDEs:

- IntelliJ IDEA
- Eclipse
- Visual Studio Code
- NetBeans

---

# 📥 Installation

## 1. Clone the Repository

```bash
git clone https://github.com/akshay25bce10184-sketch/Programing-in-Java-B22-B24-.git
```

## 2. Navigate to the Project

```bash
cd Programing-in-Java-B22-B24-
```

## 3. Open the Project

Open the repository in your preferred Java IDE.

---

# ▶️ Running the Application

## Using an IDE

1. Open the repository in your IDE.
2. Locate `Main.java`.
3. Verify the package structure.
4. Build the project.
5. Run the `main()` method.

## Using Command Line

Navigate to the source directory and compile the project according to its package structure.

Example:

```bash
javac -d . Javafiles/model/*.java
javac -d . Javafiles/service/*.java
javac -d . Javafiles/util/*.java
javac -d . Javafiles/Main.java
```

Run the application:

```bash
java Javafiles.Main
```

> If the repository structure changes, update the compilation commands accordingly.

---

# 🧪 Testing

Testing should cover both normal functionality and invalid-input scenarios.

## Authentication Tests

| Test Case | Expected Result |
|---|---|
| Valid credentials | Login successful |
| Invalid username | Login rejected |
| Invalid password | Login rejected |
| New user registration | User registered |

## Student Management Tests

| Test Case | Expected Result |
|---|---|
| Add valid student | Student added |
| Duplicate student ID | Operation rejected |
| Search existing student | Student displayed |
| Search invalid ID | Appropriate message displayed |
| Update student | Details updated |
| Delete student | Student removed |

## Attendance Tests

| Test Case | Expected Result |
|---|---|
| Valid attendance | Attendance accepted |
| Invalid attendance | Input rejected |
| Calculate percentage | Correct percentage |
| Attendance below 75% | Shortage identified |

## Performance Tests

| Test Case | Expected Result |
|---|---|
| Valid marks | Marks accepted |
| Marks outside valid range | Input rejected |
| Calculate average | Correct average |
| Calculate grade | Correct grade |

## Report Tests

| Test Case | Expected Result |
|---|---|
| Generate student report | Consolidated report generated |
| Missing attendance data | Handled appropriately |
| Missing performance data | Handled appropriately |

### Recommended Future Testing

For a stronger production-quality implementation, add:

- JUnit unit tests
- Integration tests
- Automated regression tests
- Test coverage reporting

---

# 🛡️ Validation & Error Handling

The system uses validation and controlled error handling to improve reliability.

Validation includes:

- Student ID validation
- Numeric input validation
- Marks range validation
- Attendance validation
- Duplicate student detection
- Invalid student search handling
- Authentication validation

The objective is to prevent invalid user input from causing unexpected application behavior.

---

# 📋 Non-Functional Requirements

## Usability

The system provides a menu-driven interface with clearly defined operations and user feedback.

## Reliability

Validation and controlled error handling reduce common input-related failures.

## Maintainability

The separation of models, services, and utilities makes individual components easier to understand and modify.

## Performance

The current implementation is designed for small-to-medium academic datasets using Java collections and local file storage.

## Portability

The application uses standard Java APIs and can run on operating systems supporting the required Java version.

## Resource Efficiency

The application uses lightweight local storage and in-memory collections without requiring an external server.

## Security

Sensitive information should not be committed to the repository, and production deployment should use secure credential management.

---

# 🧠 Design Decisions

## Why Java?

Java was selected because it is the primary programming language for CSE2006 and provides support for:

- Object-oriented programming
- Collections
- Exception handling
- File I/O
- Packages
- Multithreading
- Database connectivity

## Why Layered Architecture?

Separating the application into model, service, utility, and main layers improves:

- Maintainability
- Readability
- Modularity
- Reusability
- Future extensibility

## Why CSV Storage?

CSV provides a simple, portable local storage mechanism without requiring external database configuration.

For larger deployments, JDBC/database storage is recommended.

---

# ⚠️ Current Limitations

The current version has the following limitations:

1. The application uses a console-based interface.
2. CSV files are used instead of a relational database.
3. Attendance and performance records are currently maintained in memory.
4. Student lookup may require linear collection traversal.
5. The application is primarily designed for local execution.
6. There is no web-based interface.
7. There is no graphical dashboard.
8. Automated unit-test integration can be expanded.
9. Password handling requires stronger security for production use.
10. JDBC/JPA database persistence has not yet been implemented.
11. Multithreading and synchronization are not currently core application features.

These limitations are documented to clearly distinguish the current implementation from planned enhancements.

---

# 🚀 Future Enhancements

## 🗄️ Database Integration

- JDBC connectivity
- Relational database support
- Persistent attendance records
- Persistent performance records
- SQL-based CRUD operations
- Database-backed authentication

## 🔐 Security Enhancements

- Password hashing
- Salted credentials
- Secure configuration
- Granular role-based permissions
- Improved authentication controls

## 🧵 Multithreading

Potential applications include:

- Concurrent report generation
- Background data processing
- Synchronized access to shared resources

## 🖥️ Graphical User Interface

Possible technologies:

- JavaFX
- Swing

Potential features:

- Dashboard
- Interactive tables
- Forms
- Attendance charts
- Performance graphs

## 📊 Advanced Analytics

- Attendance trends
- Performance trends
- Student ranking
- Subject-wise analytics
- Low-attendance identification
- Academic performance analysis

## 🧪 Automated Testing

- JUnit integration
- Unit testing
- Integration testing
- Regression testing
- Improved test coverage

## 📄 Advanced Reporting

- PDF report generation
- CSV report export
- Graphical reports
- Attendance analytics
- Performance analytics

---

# 🎓 CSE2006 Syllabus Mapping

The project applies concepts covered in the **CSE2006 – Programming in Java** curriculum.

| CSE2006 Topic | Project Application |
|---|---|
| Java Basics | Core application logic and control flow |
| Variables & Data Types | Student and application data |
| Operators | Calculations and validation |
| Conditional Statements | Business logic and validation |
| Loops | Menu and record processing |
| Classes & Objects | Model and service classes |
| Constructors | Object initialization |
| Methods | Service and utility operations |
| Encapsulation | Organization of data and operations |
| Access Modifiers | Class/member access |
| Packages | `model`, `service`, `util` |
| Collections | `ArrayList`, `HashMap` |
| Exception Handling | Input and operation error handling |
| String Handling | Student and authentication data |
| File I/O | CSV reading and writing |
| Modular Programming | Layered application structure |
| Multithreading | Future enhancement |
| Synchronization | Future enhancement |
| JDBC | Future database enhancement |
| JPA | Future persistence enhancement |

---

# 📐 Documentation

The project should maintain the following documentation artefacts:

## System Design

- System Architecture Diagram
- Workflow Diagram
- Use Case Diagram
- Class Diagram
- Sequence Diagram
- ER Diagram when database storage is introduced

## Project Documentation

The detailed project report should include:

1. Cover Page
2. Introduction
3. Problem Statement
4. Functional Requirements
5. Non-Functional Requirements
6. System Architecture
7. Design Diagrams
8. Design Decisions and Rationale
9. Implementation Details
10. Screenshots / Results
11. Testing Approach
12. Challenges Faced
13. Learnings and Key Takeaways
14. Future Enhancements
15. References

---

# 📸 Screenshots

Screenshots should be stored under:

```text
docs/
└── screenshots/
    ├── login.png
    ├── main-menu.png
    ├── student-management.png
    ├── attendance.png
    ├── performance.png
    └── report.png
```

Recommended screenshots:

1. Login screen
2. Main menu
3. Student registration
4. Student list
5. Attendance management
6. Performance management
7. Attendance shortage result
8. Consolidated student report

---

# 🗂️ Recommended Repository Contents

A professional repository should contain:

```text
Programing-in-Java-B22-B24-/
│
├── studentmanagment/
│   └── src/
│
├── docs/
│   ├── architecture.png
│   ├── workflow.png
│   ├── use-case.png
│   ├── class-diagram.png
│   ├── sequence-diagram.png
│   └── screenshots/
│
├── README.md
├── statement.md
├── PROJECT_REPORT.pdf
├── LICENSE
└── .gitignore
```

---

# 📄 Required `statement.md`

The repository should contain a separate `statement.md` file covering:

```text
Problem Statement
Scope of the Project
Target Users
High-Level Features
```

This keeps the project requirements separate from the technical README.

---

# 🔄 Repository & Git Guidelines

Git is used for source-code version control.

Recommended workflow:

```bash
git status
git add .
git commit -m "Describe the change"
git push origin main
```

Use meaningful commit messages.

Examples:

```text
Add student management module
Implement attendance validation
Improve performance calculation
Add report generation
Fix authentication validation
Update project documentation
Add testing documentation
```

Avoid committing:

- Passwords
- API keys
- Database credentials
- Personal tokens
- Temporary files
- IDE-specific files
- Compiled `.class` files

---

# 🚫 Recommended `.gitignore`

Example:

```gitignore
# Java compiled files
*.class

# Build directories
out/
build/
target/

# IDE files
.idea/
*.iml
.vscode/
.project
.classpath
.settings/

# Operating system files
.DS_Store
Thumbs.db

# Sensitive configuration
.env
*.env
*.secret
config.properties
users.csv

# Temporary files
*.tmp
*.log
```

---

# 🔒 Data & Privacy Guidelines

The project may handle student-related information.

Therefore:

- Do not commit real student personal information.
- Do not publish real authentication credentials.
- Do not include private institutional data.
- Use sample/demo data in the public repository.
- Keep sensitive configuration outside version control.

For production deployment, additional privacy and security controls would be required.

---

# 🤝 Contributing

This project is primarily developed for academic purposes.

Suggestions and improvements are welcome.

## Contribution Process

1. Fork the repository.
2. Create a feature branch.
3. Implement the change.
4. Test the change.
5. Commit using a meaningful message.
6. Push the branch.
7. Create a Pull Request.

Example:

```bash
git checkout -b feature/improve-attendance
git add .
git commit -m "Improve attendance validation"
git push origin feature/improve-attendance
```

---

# 🧑‍💻 Author

## Akshay Pratap Singh

**Registration No.:** 25BCE10184

**Course:** CSE2006 – Programming in Java

**Slot:** B22 + B24

---

# 🙏 Acknowledgements

This project was developed as part of the **CSE2006 – Programming in Java** course.

The project applies concepts learned from the course curriculum, including:

- Core Java
- Object-Oriented Programming
- Collections
- Exception Handling
- File I/O
- Modular Programming

Acknowledgement is also given to the course faculty, academic resources, laboratory exercises, and learning materials used during development.

---

# 📚 References

1. Herbert Schildt, *Java: The Complete Reference*, 11th Edition, Oracle Press.
2. Oracle Java Documentation.
3. CSE2006 – Programming in Java Course Material.
4. Course-provided laboratory exercises and learning resources.

---

# 📜 License

This project is licensed under the **MIT License**.

The MIT License permits use, copying, modification, merging, publishing, distribution, sublicensing, and selling of copies of the software, subject to the conditions stated in the license.

See the [`LICENSE`](LICENSE) file for the complete license text.

## MIT License

Copyright (c) 2026 Akshay Pratap Singh

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.

---

# ⭐ Project Summary

The **Smart Student Attendance & Performance Management System** demonstrates the practical application of Java programming concepts to an academic management problem.

### Current Capabilities

- 🔐 User Authentication
- 👨‍🎓 Student Management
- 📊 Attendance Management
- 📝 Performance Management
- 📄 Report Generation
- ✅ Input Validation
- 💾 CSV-Based Storage
- 🧩 Modular Java Architecture

### Planned Improvements

- 🗄️ JDBC Database Integration
- 🔐 Secure Password Hashing
- 🧵 Multithreading & Synchronization
- 🧪 JUnit Testing
- 🖥️ GUI
- 📊 Advanced Analytics
- 📄 Advanced Report Export

---

# 🌟 Final Note

This project is intended as an academic demonstration of Java programming and software design concepts.

The implementation prioritizes:

**Modularity → Maintainability → Validation → Course Relevance → Extensibility**

The architecture provides a foundation for future expansion into a database-backed, secure, multi-user academic management system.

---

<p align="center">

<strong>Built with Java ☕</strong>

<br>

<strong>CSE2006 – Programming in Java</strong>

<br><br>

© 2026 Akshay Pratap Singh

</p>
