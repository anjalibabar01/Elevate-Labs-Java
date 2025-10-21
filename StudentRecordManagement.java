import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Record Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    students.add(new Student(id, name, marks));
                    System.out.println(" Student added successfully!");
                    break;

                case 2:
                    System.out.println("\n--- Student Records ---");
                    if (students.isEmpty()) {
                        System.out.println("No records found!");
                    } else {
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID to Update: ");
                    int updateId = sc.nextInt();
                    boolean foundUpdate = false;
                    for (Student s : students) {
                        if (s.id == updateId) {
                            sc.nextLine(); // consume newline
                            System.out.print("Enter New Name: ");
                            s.name = sc.nextLine();
                            System.out.print("Enter New Marks: ");
                            s.marks = sc.nextDouble();
                            System.out.println(" Record updated successfully!");
                            foundUpdate = true;
                            break;
                        }
                    }
                    if (!foundUpdate)
                        System.out.println(" Student not found!");
                    break;

                case 4:
                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = sc.nextInt();
                    boolean foundDelete = false;
                    for (Student s : students) {
                        if (s.id == deleteId) {
                            students.remove(s);
                            System.out.println(" Student record deleted!");
                            foundDelete = true;
                            break;
                        }
                    }
                    if (!foundDelete)
                        System.out.println(" Student not found!");
                    break;

                case 5:
                    System.out.println(" Exiting... Thank you!");
                    break;

                default:
                    System.out.println(" Invalid choice! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
