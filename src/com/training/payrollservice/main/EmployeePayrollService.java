package com.training.payrollservice.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    final static Scanner SCANNEROBJ = new Scanner(System.in);
    public EmployeePayrollService() {

    }

    public enum IOService {
        CONSOLE_IO, FILE_IO, DB_IO, REST_IO
    }

    ArrayList<EmployeePayroll> employeeList = new ArrayList<>();

    public EmployeePayrollService(List<EmployeePayroll> asList) {
        this.employeeList = employeeList;
    }

    public void writeEmployeeData(IOService ioType) {
        if (ioType.equals(IOService.CONSOLE_IO)) {
            for (EmployeePayroll o : employeeList)
                System.out.println(o.toString());
        } else if (ioType.equals(IOService.FILE_IO)) {
            new EmployeePayrollServiceIOFile().writeData(employeeList);
        }
    }

    public long countEnteries(IOService ioType) {
        if (ioType.equals(IOService.FILE_IO))
            return new EmployeePayrollServiceIOFile().countEntries();
        return 0;
    }

    public void readEmployeeData(IOService ioType) {
        if (ioType.equals(IOService.CONSOLE_IO)) {
            System.out.println("Enter employee id:");
            int employeeId = SCANNEROBJ.nextInt();
            System.out.println("Enter employee name:");
            SCANNEROBJ.nextLine();
            String employeeName = SCANNEROBJ.nextLine();
            System.out.println("Enter employee salary:");
            double employeeSalary = SCANNEROBJ.nextDouble();
            EmployeePayroll newEmployee = new EmployeePayroll(employeeId, employeeSalary,employeeName);
            employeeList.add(newEmployee);
        } else if (ioType.equals(IOService.FILE_IO)) {
            this.employeeList = (ArrayList<EmployeePayroll>) new EmployeePayrollServiceIOFile().readData();
        }
    }

    public int sizeOfEmployeeList() {
        return this.employeeList.size();
    }

    public void printEmployeePayrollData() {
        new EmployeePayrollServiceIOFile().printEmployeePayrolls();
    }


}
