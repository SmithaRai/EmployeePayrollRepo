package com.bridgelabz.employeepayrollrepo.Controller;


import com.bridgelabz.employeepayrollrepo.DTO.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollrepo.DTO.ResponseDTO;
import com.bridgelabz.employeepayrollrepo.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollrepo.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollRepoController {
    @Autowired
    private IEmployeePayrollService employeePayrollService;


    @RequestMapping(value={"","/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList = null ;
        empDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful",empDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId")int empId) {
        EmployeePayrollData empData=null;
        empData =  employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO respDTO = new ResponseDTO("Get Call For ID Successful",empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable String department){
        List<EmployeePayrollData> employeePayrollDataList = null;
        employeePayrollDataList = employeePayrollService.getEmployeesByDepartment(department);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For Department Successful",employeePayrollDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayrollData(@Valid@RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successful",empData);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }



    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId")int empId,@Valid @RequestBody EmployeePayrollDTO empPayrollDTO){
        EmployeePayrollData empData = null ;
        empData = employeePayrollService.updateEmployeePayrollData(empId,empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully",empData);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully ","Deleted id : " +empId);
        return new ResponseEntity<ResponseDTO>(respDTO ,HttpStatus.OK);
    }
}
