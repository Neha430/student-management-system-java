import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Student> students = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-6.");
            }
        }

        System.out.println("\nThank you for using Student Management System!");
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n==============================================");
        System.out.println("       STUDENT MANAGEMENT SYSTEM");
        System.out.println("==============================================");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
        System.out.println("==============================================");
    }

    private static void addStudent() {
        System.out.println("\n--- Add Student ---");

        int id = readInt("Enter student ID: ");

        if (findStudentById(id) != null) {
            System.out.println("A student with this ID already exists.");
            return;
        }

        String name = readNonEmptyString("Enter student name: ");
        int age = readIntInRange("Enter age: ", 1, 100);
        String course = readNonEmptyString("Enter course: ");
        double marks = readDoubleInRange("Enter marks (0-100): ", 0, 100);

        Student student = new Student(id, name, age, course, marks);
        students.add(student);

        System.out.println("Student added successfully.");
    }

    private static void viewStudents() {
        System.out.println("\n--- All Students ---");

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void searchStudent() {
        System.out.println("\n--- Search Student ---");
        int id = readInt("Enter student ID to search: ");

        Student student = findStudentById(id);

        if (student != null) {
            System.out.println("Student found:");
            System.out.println(student);
        } else {
            System.out.println("Student with ID " + id + " was not found.");
        }
    }

    private static void updateStudent() {
        System.out.println("\n--- Update Student ---");
        int id = readInt("Enter student ID to update: ");

        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("Student with ID " + id + " was not found.");
            return;
        }

        System.out.println("Current details:");
        System.out.println(student);

        String name = readNonEmptyString("Enter new name: ");
        int age = readIntInRange("Enter new age: ", 1, 100);
        String course = readNonEmptyString("Enter new course: ");
        double marks = readDoubleInRange("Enter new marks (0-100): ", 0, 100);

        student.setName(name);
        student.setAge(age);
        student.setCourse(course);
        student.setMarks(marks);

        System.out.println("Student updated successfully.");
    }

    private static void deleteStudent() {
        System.out.println("\n--- Delete Student ---");
        int id = readInt("Enter student ID to delete: ");

        Student student = findStudentById(id);

        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student with ID " + id + " was not found.");
        }
    }

    private static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static int readIntInRange(String message, int min, int max) {
        while (true) {
            int value = readInt(message);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Please enter a value between " + min + " and " + max + ".");
        }
    }

    private static double readDoubleInRange(String message, double min, double max) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();

            try {
                double value = Double.parseDouble(input.trim());

                if (value >= min && value <= max) {
                    return value;
                }

                System.out.println("Please enter a value between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static String readNonEmptyString(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("This field cannot be empty.");
        }
    }
}
