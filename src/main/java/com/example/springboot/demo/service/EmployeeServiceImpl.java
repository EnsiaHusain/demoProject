package com.example.springboot.demo.service;

import com.example.springboot.demo.domain.Employee;
import com.example.springboot.demo.repository.EmployeeRepository;
import javafx.scene.control.TableColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployees(){
      return  (List<Employee>)employeeRepository.findAll();
    }
    public void saveEmployee(Employee emp){
        employeeRepository.save(emp);
    }
    public void updateEmployee(Employee emp){
        employeeRepository.save(emp);
    }
    public Employee findEmployee(String empId){

        if(employeeRepository.findById(empId).isPresent()){
            return employeeRepository.findById(empId).get();
        }
        return null;
    }
    public void deleteEmployee(String empId){
         employeeRepository.deleteById(empId);
    }

    public List<Employee> findEmployeeByFirstName(String firstName) { return employeeRepository.findByFirstName(firstName);}

    public List<Employee> findEmployeeByFirstNameContains(String name) {
        return employeeRepository.findByFirstNameContains(name);
    }

    public Page<Employee> findByAllPaging(Pageable pageable){
        return employeeRepository.findAll(pageable);
    }

    public Iterable<Employee> findAllFirstName(){
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC,"firstName","email"));

    }

    public Page<Employee> findByPagingSort(){
       // return employeeRepository.findAll(PageRequest.of(1,100, Sort.Direction.DESC,"firstName"));

        return employeeRepository.findAll(PageRequest.of(1,100,Sort.by(Sort.Direction.DESC,"firstName","email")));
    }

    public List<Employee> findEmpByFirstName(String fName){
        return employeeRepository.findEmpByFirstName(fName);
    }

   public  void updateEmpByFirstName(String fName,String lName){
        employeeRepository.updateEmpByFirstName(fName,lName);
    }

    public List<Object[]> findAllByName(String fName,String lName){
        return employeeRepository.findAllByName(fName,lName);
    }
}
