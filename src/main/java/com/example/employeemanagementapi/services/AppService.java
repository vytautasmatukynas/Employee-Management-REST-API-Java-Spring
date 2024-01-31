package com.example.employeemanagementapi.services;

import com.example.employeemanagementapi.models.Employee;

import java.util.List;

/**
 * Service interface for managing Employee entities.
 * This interface defines methods for performing CRUD operations on Employee resources.
 */
public interface AppService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    List<Employee> findEmployee(String searchParam);

    Employee addEmployee(Employee employee);

    Employee updateEmployee(Long id, Employee employee);

    String deleteEmployee(Long id);

}
