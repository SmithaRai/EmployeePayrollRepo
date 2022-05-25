package com.bridgelabz.employeepayrollrepo.service;

import com.bridgelabz.employeepayrollrepo.repository.EmployeePayrollRepository;
import com.bridgelabz.employeepayrollrepo.DTO.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollrepo.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollrepo.model.EmployeePayrollData;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{

    @Autowired
    EmployeePayrollRepository employeePayrollRepository;

    public List<EmployeePayrollData> getEmployeePayrollData(){
        return  employeePayrollRepository.findAll();
    }

    public EmployeePayrollData getEmployeePayrollDataById(int empId){
        return employeePayrollRepository
                .findById(empId)
                .orElseThrow(()->new EmployeePayrollException("Employee with employeeId "+empId + "does not exists...!!"));
    }

    @Override
    public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
        return employeePayrollRepository.findEmployeesByDepartment(department);
    }
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO){
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(empPayrollDTO);
        log.debug("Emp Data: "+empData.toString());
        return employeePayrollRepository.save(empData);

    }
    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.updateEmployeePayrollData(empPayrollDTO);
        return employeePayrollRepository.save(empData);
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        employeePayrollRepository.delete(empData);
    }
}
