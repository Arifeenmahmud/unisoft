package com.unisoft.unisoft.controller;

import com.unisoft.unisoft.entity.Employee;
import com.unisoft.unisoft.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService  service;

    @PostMapping
    public Employee create(@Valid @RequestBody Employee employee) {
        return service.save(employee);
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.listAll();
    }
}
