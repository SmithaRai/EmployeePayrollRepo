package com.bridgelabz.employeepayrollrepo.model;

import com.bridgelabz.employeepayrollrepo.DTO.EmployeePayrollDTO;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee_payroll")
public @Data @NoArgsConstructor class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int employeeId;
    @Column(name = "name")
    private String name;
    private Long salary;
    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department",
            joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> department;

    public EmployeePayrollData( EmployeePayrollDTO employeePayrollDTO) {
        this.employeeId= employeeId;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.startDate = employeePayrollDTO.startDate;
        this.note=employeePayrollDTO.note;
        this.profilePic=employeePayrollDTO.profilePic;
        this.department=employeePayrollDTO.department;

    }
}
