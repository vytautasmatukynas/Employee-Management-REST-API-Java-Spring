package com.example.employeemanagementapi.controllers;

import com.example.employeemanagementapi.models.Employee;
import com.example.employeemanagementapi.services.AppService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(appService.addEmployee(employee));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
                                                   @RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(appService.updateEmployee(id, employee));
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<String> deleteRestoreEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(appService.deleteEmployee(id));
    }

}
