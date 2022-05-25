package com.bridgelabz.employeepayrollrepo.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public class EmployeePayrollDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$" , message = "Employee name Invalid")
    @NotEmpty(message = "Employee name cannot be null")
    public String name;
    @Min(value = 500,message = "Min Wage should be more than 500")
    public Long salary;
    @Pattern(regexp = "male|female",message = "Gender needs to be male or female")
    public String gender;
    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "startDate should Not be Empty")
    @PastOrPresent (message = "startDate should be past or todays date")
    public LocalDate startDate;
    @NotBlank(message = "Note cannot be empty")
    public String note;
    @NotBlank(message = "profilePic cannot be empty")
    public String profilePic;
    @NotNull (message = "department should not be empty")
    public List<String> department;

}
