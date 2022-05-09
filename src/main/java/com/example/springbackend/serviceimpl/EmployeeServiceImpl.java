package com.example.springbackend.serviceimpl;

import com.example.springbackend.Models.Employee;
import com.example.springbackend.Repository.EmployeeRepository;
import com.example.springbackend.Service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        super();
        this.employeeRepository = employeeRepository;
    }

    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);

    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> empList = new ArrayList<Employee>();
        Iterator iterateEmp=  employeeRepository.findAll().iterator();
        while(iterateEmp.hasNext()){
            empList.add((Employee) iterateEmp.next());
        }

        return empList;
    }

    @Override
    public Employee findEmployee(long id) {
        return employeeRepository.findById(id);
    }


    @Override
    public void deleteEmployee(Employee empl){
        employeeRepository.delete(empl);
    }
}
