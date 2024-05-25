package com.kamil.mydemo.service;

import com.kamil.mydemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(Long id);

    void save(Employee employee);

    void deleteById(Long id);

}
