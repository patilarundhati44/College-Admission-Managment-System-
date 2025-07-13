package app;

import dao.AdmissionService;
import entity.Admission;
import entity.Course;
import entity.Student;

import java.util.List;
import java.util.Scanner;

public class App {

    private static final AdmissionService service = new AdmissionService();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            printMenu();
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    addCourse();
                    break;

                case 3:
                    admitStudent();
                    break;

                case 4:
                    listAdmissions();
                    break;

                case 5:
                    listCourses();
                    break;

                case 0:
                    System.out.println("👋 Exiting... Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n===== College Admission Management System =====");
        System.out.println("1. Add Student");
        System.out.println("2. Add Course");
        System.out.println("3. Admit Student to Course");
        System.out.println("4. List All Admissions");
        System.out.println("5. List All Courses");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addStudent() {
        Student student = new Student();
        System.out.print("Enter student name: ");
        student.setName(sc.nextLine());
        System.out.print("Enter email: ");
        student.setEmail(sc.nextLine());
        System.out.print("Enter phone: ");
        student.setPhone(sc.nextLine());

        service.addStudent(student);
        System.out.println("✅ Student added successfully.");
    }

    private static void addCourse() {
        Course course = new Course();
        System.out.print("Enter course name: ");
        course.setCourseName(sc.nextLine());
        System.out.print("Enter duration (in months): ");
        course.setDuration(sc.nextInt());
        sc.nextLine(); // consume newline

        service.addCourse(course);
        System.out.println("✅ Course added successfully.");
    }

    private static void admitStudent() {
        System.out.print("Enter student ID: ");
        int sid = sc.nextInt();
        System.out.print("Enter course ID: ");
        int cid = sc.nextInt();
        sc.nextLine(); // consume newline

        Student s = service.getStudentById(sid);
        Course c = service.getCourseById(cid);

        if (s != null && c != null) {
            service.admitStudent(s, c);
            System.out.println("✅ Admission successful.");
        } else {
            System.out.println("❌ Student or Course not found.");
        }
    }

    private static void listAdmissions() {
        List<Admission> admissions = service.listAdmissions();
        System.out.println("\n--- Admission Records ---");
        for (Admission a : admissions) {
            System.out.println("Admission ID: " + a.getAdmissionId() +
                    ", Student: " + a.getStudent().getName() +
                    ", Course: " + a.getCourse().getCourseName() +
                    ", Date: " + a.getAdmissionDate());
        }
    }

    private static void listCourses() {
        List<Course> courses = service.listCourses();
        System.out.println("\n--- Available Courses ---");
        for (Course c : courses) {
            System.out.println("Course ID: " + c.getCourseId() +
                    ", Name: " + c.getCourseName() +
                    ", Duration: " + c.getDuration() + " months");
        }
    }
}
