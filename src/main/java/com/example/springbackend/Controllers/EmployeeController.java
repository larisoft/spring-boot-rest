package com.example.springbackend.Controllers;

import com.example.springbackend.Models.Employee;
import com.example.springbackend.Repository.EmployeeRepository;
import com.example.springbackend.exceptions.CrudResourceNotFoundException;
import com.example.springbackend.serviceimpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){

        return  new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);

    }


    @GetMapping("/list")
    public  List<Employee> listEmployees(){
        return employeeService.getAllEmployees();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee (@RequestBody Employee employee, @PathVariable long id) throws CrudResourceNotFoundException {

        Employee existingEmployee = employeeService.findEmployee(id);

        if(employee== null){
            throw new CrudResourceNotFoundException("Employee", "Employee", employee);
        }

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeService.saveEmployee(existingEmployee);

        return new ResponseEntity<Employee>(existingEmployee, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee ( @PathVariable long id) throws CrudResourceNotFoundException {

        Employee existingEmployee = employeeService.findEmployee(id);
        return new ResponseEntity<Employee>(existingEmployee, HttpStatus.CREATED);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<Employee> updateEmployee ( @PathVariable long id) throws CrudResourceNotFoundException {

        Employee existingEmployee = employeeService.findEmployee(id);

        if(existingEmployee== null){
            throw new CrudResourceNotFoundException("Employee", "Id", id);
        }

        employeeService.deleteEmployee(existingEmployee);
        return new ResponseEntity<Employee>(existingEmployee, HttpStatus.OK);
    }
}
