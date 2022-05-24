package com.bridgelabz.employeepayrollrepo.DTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

public class EmployeePayrollDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s] {2,} $" , message = "Employee name Invalid")
    @NotEmpty(message = "Employee name cannot be null")
    public String name;
    @Min(value = 500,message = "Min Wage should be more than 500")
    public Long salary;
    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;
    public List<String> department;

}
