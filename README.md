Student Management System Using Java
Project Overview
A console-based Student Management System developed in Java to manage student records through a simple menu-driven interface.
Features
Add a new student
View all student records
Search a student by ID
Update student information
Delete a student record
Automatic grade calculation from marks
Input validation and exception handling
Duplicate student ID prevention
Technologies & Concepts
Java
Object-Oriented Programming (OOP)
ArrayList
Scanner
Exception Handling
CRUD Operations
Encapsulation
Classes, Objects, Constructors, Getters and Setters
Project Files
File	Description
`Main.java`	Contains the menu, user input handling, and CRUD operations.
`Student.java`	Student model containing student details and grade calculation.
How to Run
Requirements
Java JDK 8 or later
Command Prompt / Terminal / VS Code / IntelliJ IDEA / Eclipse
Using Command Prompt or Terminal
Open the project folder.
Compile the files:
```bash
javac Student.java Main.java
```
Run the application:
```bash
java Main
```
Menu
```text
==============================================
       STUDENT MANAGEMENT SYSTEM
==============================================
1. Add Student
2. View All Students
3. Search Student
4. Update Student
5. Delete Student
6. Exit
==============================================
```
Data Storage
The current version stores student records temporarily in an in-memory `ArrayList`. Records are cleared when the application is closed.
Future Enhancements
MySQL database integration using JDBC
User login and authentication
GUI using Java Swing or JavaFX
Attendance management
Subject-wise marks
Report generation
Author
Neha Samanta
B.Tech – Information Technology
