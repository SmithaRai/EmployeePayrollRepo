package com.bridgelabz.employeepayrollrepo.model;

import com.bridgelabz.employeepayrollrepo.DTO.EmployeePayrollDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


public @Data class EmployeePayrollData {
    private int employeeId;
    private String name;
    private Long salary;
    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;
    private List<String> department;

    public EmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        this.employeeId= empId;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.startDate = employeePayrollDTO.startDate;
        this.note=employeePayrollDTO.note;
        this.profilePic=employeePayrollDTO.profilePic;
        this.department=employeePayrollDTO.department;

    }
}
