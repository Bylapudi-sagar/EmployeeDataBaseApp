package com.jsp.EmployeeDBApp.service;


import java.util.List;
import java.util.Scanner;

import com.jsp.EmployeeDBApp.dao.EmployeeDAO;
import com.jsp.EmployeeDBApp.dto.Employee;

public class EmployeeService {
    private EmployeeDAO dao = new EmployeeDAO();
    private Scanner sc = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("\n***** Employee Database App *****");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5.Fetch Employee");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: addEmployee(); break;
                case 2: viewEmployees(); break;
                case 3: updateSalary(); break;
                case 4: deleteEmployee(); break;
                case 5: fetchEmployee(); break;
                case 6: System.out.println("Thank you for using the Employee Database Application. Have a great day!"); return;
                default: System.out.println(" Invalid choice!");
            }
        }
    }

    private void addEmployee() {
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        dao.addEmployee(new Employee(name, email, dept, salary));
    }

    private void viewEmployees() {
        List<Employee> list = dao.getAllEmployees();
        System.out.println("\nID\tName\tEmail\tDepartment\tSalary");
        for (Employee emp : list) {
            System.out.println(emp);
        }
    }

    private void updateSalary() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        System.out.print("Enter New Salary: ");
        double salary = sc.nextDouble();
        dao.updateSalary(id, salary);
    }

    private void deleteEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        dao.deleteEmployee(id);
    }
    
    private void fetchEmployee() {
        System.out.print("Enter Employee ID to Fetch: ");
        int id = sc.nextInt();
        Employee emp = dao.fetchEmployeeById(id);
        if (emp != null) {
            System.out.println("\nID\tName\tEmail\tDepartment\tSalary");
            System.out.println(emp);
        } else {
            System.out.println(" Employee not found.");
        }
    }

}

