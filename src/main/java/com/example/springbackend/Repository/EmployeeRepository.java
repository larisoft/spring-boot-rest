package com.example.springbackend.Repository;

import com.example.springbackend.Models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {


    Employee findById(long id);
}
