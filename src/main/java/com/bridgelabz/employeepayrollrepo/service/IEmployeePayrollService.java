package com.bridgelabz.employeepayrollrepo.service;

import com.bridgelabz.employeepayrollrepo.DTO.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollrepo.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayrollData> getEmployeePayrollData();
    EmployeePayrollData getEmployeePayrollDataById(int empId);

    List<EmployeePayrollData> getEmployeesByDepartment(String department);
    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(int empId ,EmployeePayrollDTO empPayrollDTO);
    void deleteEmployeePayrollData(int empId);

}
