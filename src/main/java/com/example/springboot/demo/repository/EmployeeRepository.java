package com.example.springboot.demo.repository;

import com.example.springboot.demo.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,String>
        //extends JpaRepository<Employee,String>
{

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByFirstNameContains(String name);

    @Query("from Employee where firstName = :fName")
    List<Employee> findEmpByFirstName(String fName);

    @Modifying
    @Query("Update Employee set lastName = :lName where firstName = :fName")
    void updateEmpByFirstName(String fName,String lName);

    @Query("Select firstName,lastName from Employee where firstName = :fName and lastName = :lName")
    List<Object[]> findAllByName(String fName,String lName);

}
