package com.example.employeemanagementapi.repositories;

import com.example.employeemanagementapi.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for accessing Employee entities.
 * This interface provides methods for CRUD operations on the Employee entity using Spring Data JPA.
 */
@Repository
public interface AppRepository extends JpaRepository<Employee, Long> {

    List<Employee> findEmployeeByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
            String name, String lastName);

}
