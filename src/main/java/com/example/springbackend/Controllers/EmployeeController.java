package com.example.springbackend.Controllers;

import com.example.springbackend.Models.Employee;
import com.example.springbackend.Repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeDAO empRepository;

    @GetMapping("/save")
    public List<Employee> saveEmployee(){

        Employee newEmp = new Employee("Hilary", "Okeke", "larypetero@gmail.com");

        empRepository.save(newEmp);
        List<Employee> empList = new ArrayList<Employee>();
        Iterator iterateEmp=  empRepository.findAll().iterator();
        while(iterateEmp.hasNext()){

            empList.add((Employee) iterateEmp.next());
        }

        return empList;

    }
}
