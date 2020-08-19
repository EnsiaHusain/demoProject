package com.example.springboot.demo.controller;

import com.example.springboot.demo.domain.Employee;
import com.example.springboot.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/demo")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> fetchAllEmployees(){
        return employeeService.findAllEmployees();
    }

    @GetMapping("/employee/{empId}")
    public Employee fetchEmployee(@PathVariable("empId") String empId){
        return employeeService.findEmployee(empId);
    }

    @PostMapping("/employee/save")
    public void saveEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
    }

    @PutMapping("/employee/update")
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/employee/delete/{empId}")
    public void deleteEmployee(@PathVariable("empId") String empId){
        employeeService.deleteEmployee(empId);
    }

    @GetMapping("/employee/findBy/{firstName}")
    public List<Employee> findByFirstName(@PathVariable("firstName") String firstName){
        //return employeeService.findEmployeeByFirstName(firstName);
        return employeeService.findEmployeeByFirstNameContains(firstName);
    }

    @GetMapping("/employee/findAll")
    public List<Employee> findByAllPaging(@Param("pageNo") int pageNo, @Param("size") int pageSize){

        Page<Employee> employees = employeeService.findByAllPaging(PageRequest.of(pageNo,pageSize));
        employees.forEach(employee -> System.out.println(employee.getAddress()));
        return employees.getContent();

    }

    @GetMapping("/employee/findAllSort")
    public List<Employee> findAllSorting(){
        Iterable<Employee> employeeIterator = employeeService.findAllFirstName();

        List<Employee> emp = new ArrayList<>();
        for (Employee employee : employeeIterator) {
            emp.add(employee);
        }

        return emp;
    }

    @GetMapping("/employee/findAllPageSort")
    public List<Employee> findAllPagingSort(){

        Page<Employee> employees = employeeService.findByPagingSort();

        List<Employee> emps = (List<Employee>) employees.getContent();
        return emps;
    }

    @GetMapping("/employee/findAll/{fName}")
    public List<Employee> findByFName(@PathVariable("fName") String fName){
        return employeeService.findEmpByFirstName(fName);
    }

    @PostMapping("/employee/update/{fName}/{lName}")
    @Transactional
    public void updateEmpByFirstName(@PathVariable("fName") String fName,@PathVariable("lName") String lName){
        employeeService.updateEmpByFirstName(fName,lName);
    }

    @GetMapping("/employee/findAllByName")
    public List<Object[]> findAllByName(@Param("fName") String fName, @Param("lName") String lName){
        return employeeService.findAllByName(fName,lName);

    }
}
