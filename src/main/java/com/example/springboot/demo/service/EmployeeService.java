package com.example.springboot.demo.service;

import com.example.springboot.demo.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

     List<Employee> findAllEmployees();

     void saveEmployee(Employee emp);

    void updateEmployee(Employee emp);

    Employee findEmployee(String empId);

    void deleteEmployee(String empId);

    List<Employee> findEmployeeByFirstName(String firstName);

    List<Employee> findEmployeeByFirstNameContains(String name);

    Page<Employee> findByAllPaging(Pageable pageable);

    Iterable<Employee> findAllFirstName();

    Page<Employee> findByPagingSort();

    List<Employee> findEmpByFirstName(String fName);

    void updateEmpByFirstName(String fName,String lName);

    List<Object[]> findAllByName(String fName,String lName);

}
