package com.training.payrollservice.main;

import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollService {
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

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Payroll ");
        EmployeePayrollService service = new EmployeePayrollService();

        service.employeeList.add(EmployeePayroll.addEmployee());

    }
}
