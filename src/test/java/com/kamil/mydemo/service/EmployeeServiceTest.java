package com.kamil.mydemo.service;

import com.kamil.mydemo.entity.Employee;
import com.kamil.mydemo.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeServiceImpl service;

    @Test
    public void emplServiceFindById() {
        //prepare example employee;
        Employee employee = new Employee("Monica", "Bellucci", "monica@bella.it");
        // when mocked (fake?) repo is called, return example empl.
        when(repository.findById(1)).thenReturn(Optional.ofNullable(employee));

        //call real service
        Employee foundEmpl = service.findById(1L);

        Assertions.assertThat(foundEmpl).isNotNull();
    }

    @Test
    public void employeeServiceFindAll() {
        // method findAll() in service uses repo.findAllByOrderByLastNameAsc()

        List<Employee> employees = Mockito.mock(List.class);

        when(repository.findAllByOrderByLastNameAsc()).thenReturn(employees);

        List<Employee> returnedEmployees = service.findAll();

        Assertions.assertThat(returnedEmployees).isNotNull();
    }

    @Test
    public void emplServiceDeleteById() {
        // prepare employee
        Employee employee = new Employee(1L, "Monica", "Bellucci", "monica@bella.it");

        // to test delete() need id from "real" employee - so first need to find it
        // so, we need fake find and then fake delete - do nothing

        when(repository.findById(1)).thenReturn(Optional.ofNullable(employee));
        doNothing().when(repository).deleteById(Math.toIntExact(employee.getId()));

        Employee foundEmpl = service.findById(1L);
        service.deleteById(foundEmpl.getId());

        assertAll(() -> service.deleteById(1L));
    }

}
