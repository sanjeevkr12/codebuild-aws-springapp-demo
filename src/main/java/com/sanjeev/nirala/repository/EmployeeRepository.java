package com.sanjeev.nirala.repository;

import com.sanjeev.nirala.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}