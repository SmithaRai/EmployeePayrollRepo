package com.bridgelabz.employeepayrollrepo.repository;

import com.bridgelabz.employeepayrollrepo.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData,Integer> {
}
