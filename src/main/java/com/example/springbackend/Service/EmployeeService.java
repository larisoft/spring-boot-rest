package com.example.springbackend.Service;

import com.example.springbackend.Models.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();
}
