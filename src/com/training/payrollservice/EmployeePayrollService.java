package com.training.payrollservice;

import java.util.ArrayList;

public class EmployeePayrollService {
    ArrayList<EmployeePayroll> employeeList = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Payroll ");
        EmployeePayrollService service = new EmployeePayrollService();

        service.employeeList.add(EmployeePayroll.addEmployee());

    }
}
