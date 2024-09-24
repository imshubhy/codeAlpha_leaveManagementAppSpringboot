package com.codealpha.intern.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codealpha.intern.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
