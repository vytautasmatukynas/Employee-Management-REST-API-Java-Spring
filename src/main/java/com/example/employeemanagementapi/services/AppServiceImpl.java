package com.example.employeemanagementapi.services;

import com.example.employeemanagementapi.models.Employee;
import com.example.employeemanagementapi.repositories.AppRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Implementation of the {@link AppService} interface for managing Employee entities.
 * This service provides methods to perform CRUD operations on Employee resources.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class AppServiceImpl implements AppService{

    private final AppRepository appRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return appRepository.findAll().stream()
                .filter(del -> !del.isDeleted())
                .toList();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return appRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Employee not found"));
    }

    @Override
    public List<Employee> findEmployee(String searchParam) {
        Long employeeId = Long.parseLong(searchParam);

        return appRepository.findEmployeeByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmployeeId(
                searchParam, searchParam, employeeId);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeId(generateEmployeeId());
        employee.setUpdateDate(generateCurrentDate());

        return appRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = getEmployeeById(id);

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setPhoneNumber(employee.getPhoneNumber());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setAddress(employee.getAddress());
        existingEmployee.setPosition(employee.getPosition());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setJobStartDay(employee.getJobStartDay());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setUpdateDate(generateCurrentDate());

        return existingEmployee;
    }

    @Override
    public String deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);

        if (employee.isDeleted()) {
            employee.setDeleted(false);
            return String.format("Employee \"%s: %s %s\" was restored",
                    employee.getEmployeeId(), employee.getFirstName(), employee.getLastName());
        } else {
            employee.setDeleted(true);
            return String.format("Employee \"%s: %s %s\" was deleted",
                    employee.getEmployeeId(), employee.getFirstName(), employee.getLastName());
        }
    }

    private String generateCurrentDate () {
        return LocalDate.now().toString();
    }

    private Long generateEmployeeId () {
        return getAllEmployees()
                .stream()
                .mapToLong(Employee::getEmployeeId)
                .max()
                .orElse(0L) + 1L;
    }

}
