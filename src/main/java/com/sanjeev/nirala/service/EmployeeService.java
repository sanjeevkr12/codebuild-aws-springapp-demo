package com.sanjeev.nirala.service;

import com.sanjeev.nirala.entity.Employee;
import org.springframework.stereotype.Service;
import com.sanjeev.nirala.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Employee getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee update(Long id, Employee emp) {
        Employee existing = getById(id);
        existing.setName(emp.getName());
        existing.setEmail(emp.getEmail());
        existing.setDepartment(emp.getDepartment());
        existing.setSalary(emp.getSalary());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}