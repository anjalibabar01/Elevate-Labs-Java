package EmployeeDBApp;

import EmployeeDBApp.dao.EmployeeDAO;
import EmployeeDBApp.model.Employee;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Employee Database Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Department: ");
                    String dept = sc.next();
                    System.out.print("Enter Salary: ");
                    double sal = sc.nextDouble();
                    dao.addEmployee(new Employee(name, dept, sal));
                }
                case 2 -> {
                    List<Employee> list = dao.getAllEmployees();
                    if (list.isEmpty()) {
                        System.out.println("No employees found!");
                    } else {
                        for (Employee emp : list)
                            System.out.println(emp);
                    }
                }
                case 3 -> {
                    System.out.print("Enter Employee ID to update: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new salary: ");
                    double sal = sc.nextDouble();
                    dao.updateEmployee(id, sal);
                }
                case 4 -> {
                    System.out.print("Enter Employee ID to delete: ");
                    int id = sc.nextInt();
                    dao.deleteEmployee(id);
                }
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }
}
