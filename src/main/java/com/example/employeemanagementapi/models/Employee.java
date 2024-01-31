package com.example.employeemanagementapi.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model class representing an Employee entity.
 * This class defines the attributes and constraints for an employee record.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Employee {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "1001")
    @Column(unique = true)
    private Long employeeId;

    @NotBlank(message = "First name cannot be blank")
    @Schema(example = "John")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Schema(example = "Doe")
    private String lastName;

    @NotBlank(message = "Phone number cannot be blank")
    @Schema(example = "123-456-7890")
    private String phoneNumber;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    @Schema(example = "john.doe@example.com")
    private String email;

    @NotBlank(message = "Address cannot be blank")
    @Schema(example = "123 Main St, City")
    private String address;

    @NotBlank(message = "Position cannot be blank")
    @Schema(example = "Software Engineer")
    private String position;

    @NotBlank(message = "Department cannot be blank")
    @Schema(example = "Engineering")
    private String department;

    @NotBlank(message = "Job start day cannot be blank")
    @Schema(example = "2024-01-31")
    private String jobStartDay;

    @NotNull(message = "Salary cannot be null")
    @Min(value = 0, message = "Salary must be greater than or equal to 0")
    @Schema(example = "50000.0")
    private Double salary;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "2024-01-31")
    private String updateDate;

    @Schema(example = "false")
    private boolean isDeleted = false;

}

