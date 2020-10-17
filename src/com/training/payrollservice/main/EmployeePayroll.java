package com.training.payrollservice;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayroll {
    int id;
    double salary;
    String name;
    final static Scanner SCANNEROBJ = new Scanner(System.in);

    public EmployeePayroll(int id, double salary, String name) {
        this.id = id;
        this.salary = salary;
        this.name = name;
    }

    public static EmployeePayroll addEmployee(){
        System.out.println("Enter name of Employee");
        String name = SCANNEROBJ.next();

        System.out.println("Enter id of Employee ");
        int id = SCANNEROBJ.nextInt();

        System.out.println("Enter salary of Employee ");
        double salary = SCANNEROBJ.nextDouble();

        return new EmployeePayroll(id,salary,name);
    }
}
