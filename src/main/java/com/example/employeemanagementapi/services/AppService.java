package com.example.employeemanagementapi.services;

import com.example.employeemanagementapi.models.Employee;

import java.util.List;

public interface AppService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    List<Employee> findEmployee(String searchParam);

    Employee addEmployee(Employee employee);

    Employee updateEmployee(Long id, Employee employee);

    String deleteEmployee(Long id);

}
