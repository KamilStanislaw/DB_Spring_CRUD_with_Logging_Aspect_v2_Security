package com.kamil.mydemo.repository;

import com.kamil.mydemo.entity.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    @Test
    public void pplRepositorySaveAndReturnSavedEmp()  {

        Employee employee = new Employee("Michelangelo", "Buonarroti", "angel@artist.it");

        Employee savedEmp = repository.save(employee);

        Assertions.assertThat(savedEmp).isNotNull();
        Assertions.assertThat(savedEmp.getId()).isGreaterThan(0);
        System.out.println(savedEmp);
    }

    @Test
    public void pplRepositorySaveAllReturnMoreThanOneSavedEmp() {

        Employee emp1 = new Employee("Michelangelo", "Buonarroti", "michel@angelo.it");
        Employee emp2 = new Employee("Raffaello ", "Sanzio", "rafael@santi.it");

        Employee saved1 = repository.save(emp1);
        Employee saved2 = repository.save(emp2);

        List<Employee> employees = repository.findAll();

        Assertions.assertThat(employees).isNotNull();
        Assertions.assertThat(employees.size()).isEqualTo(2);
        System.out.println(employees);
    }

    @Test
    public void pplRepositoryFindByIdReturnEmp() {

        Employee employee = new Employee("Leonardo ", "da Vinci", "leonardo@da_vinci.it");

        repository.save(employee);

        Employee foundEmployee = repository.findById(Math.toIntExact(employee.getId())).get();

        Assertions.assertThat(foundEmployee).isNotNull();
        System.out.println(foundEmployee);
    }

    @Test
    public void pplRepositoryFindBylastName() {
        Employee emp1 = new Employee("Michelangelo", "Buonarroti", "michel@angelo.it");
        Employee emp2 = new Employee("Raffaello ", "Sanzio", "rafael@santi.it");
        Employee emp3 = new Employee("Leonardo ", "Da Vinci", "leonardo@da_vinci.it");

        repository.save(emp1);
        repository.save(emp2);
        repository.save(emp3);

        List<Employee> employeesByLastName = repository.findAllByOrderByLastNameAsc();

        Assertions.assertThat(employeesByLastName).isNotNull();
        Assertions.assertThat(employeesByLastName.size()).isEqualTo(3);
        System.out.println(employeesByLastName);
    }

    @Test
    public void pplRepositoryUpdateEmpAndReturnNotNull() {

        Employee employee = new Employee("Michelangelo", "Buonarroti", "angel@artist.it");
        Employee savedEmpl = repository.save(employee);
        System.out.println(savedEmpl);


        Employee foundEmpl = repository.findById(Math.toIntExact(savedEmpl.getId())).get();

        foundEmpl.setEmail("michel@angelo.it");

        Employee updatedEmpl = repository.save(foundEmpl);


        Employee updatedFoundEmpl = repository.findById(Math.toIntExact(updatedEmpl.getId())).get();
        System.out.println(updatedFoundEmpl);

        Assertions.assertThat(updatedFoundEmpl.getEmail()).isNotNull();
        Assertions.assertThat(updatedFoundEmpl.getEmail()).isNotEqualTo("angel@artist.it");

    }

    @Test
    public void pplRepositoryDeleteById() {
        Employee emp1 = new Employee("Raffaello ", "Sanzio", "rafael@santi.it");
        Employee savedEmpl = repository.save(emp1);
        System.out.println(savedEmpl);

        repository.deleteById(Math.toIntExact(savedEmpl.getId()));

        Optional<Employee> deletedEmpl = repository.findById(Math.toIntExact(savedEmpl.getId()));
        System.out.println(deletedEmpl);

        Assertions.assertThat(deletedEmpl).isEmpty();

    }

}
