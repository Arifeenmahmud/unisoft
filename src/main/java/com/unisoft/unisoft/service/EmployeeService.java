package com.unisoft.unisoft.service;

import com.unisoft.unisoft.entity.Employee;
import com.unisoft.unisoft.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class EmployeeService {

     @Autowired
    private EmployeeRepository repo;

      public List<Employee> listAll() {
        return repo.findAll();
    }

      public Employee save(Employee emp) {
        return repo.save(emp);
    }



}
