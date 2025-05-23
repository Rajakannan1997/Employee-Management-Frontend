package com.example.employee_management_system.exception;// EmployeeNotFoundException.java placeholder content


public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id) {
        super("Employee with ID " + id + " not found");
    }
}
