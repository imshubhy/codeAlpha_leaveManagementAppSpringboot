package com.codealpha.intern.service;


import com.codealpha.intern.entity.Employee;
import com.codealpha.intern.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void updateLeaveBalance(Long id, int newBalance) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            employee.setLeaveBalance(newBalance);
            employeeRepository.save(employee);
        }
    }
}
