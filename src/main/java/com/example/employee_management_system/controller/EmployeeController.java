package com.example.employee_management_system.controller;

import com.example.employee_management_system.entity.Employee;
import com.example.employee_management_system.exception.EmployeeNotFoundException;
import com.example.employee_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", repository.findAll());
        return "employee-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        repository.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }
        repository.deleteById(id);
        return "redirect:/employees";
    }

}
