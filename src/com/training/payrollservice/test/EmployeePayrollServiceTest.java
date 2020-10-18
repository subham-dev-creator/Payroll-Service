package com.training.payrollservice.test;

import com.training.payrollservice.main.EmployeePayroll;
import com.training.payrollservice.main.EmployeePayrollService.IOService;
import com.training.payrollservice.main.EmployeePayrollService;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class EmployeePayrollServiceTest {

    @Test
    public void given3EmployeesWhenWrittenToFileShouldMatchNumberOfEmployeeEntries() {
        EmployeePayroll[] arrayOfEmployees = {
                new EmployeePayroll(1, 100000, "Subham"),
                new EmployeePayroll(2, 20000, "Manoj"),
                new EmployeePayroll(3, 30000, "Kushal") };
        EmployeePayrollService payrollServiceObject = new EmployeePayrollService(Arrays.asList(arrayOfEmployees));
        payrollServiceObject.writeEmployeeData(IOService.FILE_IO);
        Assert.assertEquals(3, payrollServiceObject.countEnteries(IOService.FILE_IO));
    }

    @Test
    public void given3EmployeesWhenReadFromFileShouldMatchNumberOfEmployeeEntries() {

        EmployeePayrollService payrollServiceObject = new EmployeePayrollService();
        payrollServiceObject.readEmployeeData(IOService.FILE_IO);
        int countOfEntriesRead = payrollServiceObject.sizeOfEmployeeList();
        Assert.assertEquals(3, countOfEntriesRead);
    }
}
