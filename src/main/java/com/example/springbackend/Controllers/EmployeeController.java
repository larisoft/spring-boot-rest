package com.example.springbackend.Controllers;

import com.example.springbackend.Models.Employee;
import com.example.springbackend.Repository.EmployeeRepository;
import com.example.springbackend.serviceimpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequestMapping("/employees")
@RestController
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee){

        return employeeService.saveEmployee(employee);

    }


    @GetMapping("/list")
    public List<Employee> listEmployees(){

        return employeeService.getAllEmployees();
    }
}
