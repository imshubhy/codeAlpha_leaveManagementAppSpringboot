package com.codealpha.intern.controller;

import com.codealpha.intern.entity.Employee;
import com.codealpha.intern.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{id}/leave-balance")
    public void updateLeaveBalance(@PathVariable Long id, @RequestParam int leaveBalance) {
        employeeService.updateLeaveBalance(id, leaveBalance);
    }
}
