package com.kamil.mydemo.service;

import com.kamil.mydemo.repository.EmployeeRepository;
import com.kamil.mydemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(Long id) {
        Integer idInt = id.intValue();
        Optional<Employee> result = employeeRepository.findById(idInt);

        Employee employee = null;

        if (result.isPresent()) {
            employee = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        Integer idInt = id.intValue();
        employeeRepository.deleteById(idInt);
    }
}
