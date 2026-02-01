package com.unisoft.unisoft.repository;

import com.unisoft.unisoft.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {
}

