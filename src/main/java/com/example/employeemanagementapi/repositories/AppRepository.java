package com.example.employeemanagementapi.repositories;

import com.example.employeemanagementapi.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppRepository extends JpaRepository<Employee, Long> {

    List<Employee> findEmployeeByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmployeeId(
            String name, String lastName, Long employeeId);

}
