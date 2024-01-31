package com.example.employeemanagementapi.controllers;

import com.example.employeemanagementapi.models.Employee;
import com.example.employeemanagementapi.services.AppService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing Employee entities.
 * This class provides RESTful endpoints to perform CRUD operations on Employee resources.
 */
@Validated
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmployeeController {

    private final AppService appService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(appService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(appService.getEmployeeById(id));
    }

    @GetMapping("/search/{searchParam}")
    public ResponseEntity<List<Employee>> searchEmployees(@PathVariable String searchParam) {
        return ResponseEntity.ok(appService.findEmployee(searchParam));
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addNewEmployee(@Valid @RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(appService.addEmployee(employee));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
                                                   @Valid @RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(appService.updateEmployee(id, employee));
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<String> deleteRestoreEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(appService.deleteEmployee(id));
    }

}
