package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.save(employee);
    }

    @GetMapping(params = "!id")
    public List<Employee> getAllEmployees() {
        return service.getAll();
    }

    @GetMapping(params = "id")
    public Employee getEmployeeById(@RequestParam Long id) {
        return service.getById(id);
    }

    @DeleteMapping(params = "id")
    public String deleteEmployee(@RequestParam Long id) {
        service.deleteById(id);
        return "Employee deleted successfully";
    }

    @GetMapping(value = "/search", params = "name")
    public List<Employee> findByName(@RequestParam String name) {
        return service.searchByName(name);
    }

    @GetMapping(value = "/search", params = "department")
    public List<Employee> findByDepartment(@RequestParam String department) {
        return service.searchByDepartment(department);
    }

    @GetMapping(value = "/search", params = "phone")
    public Employee findByPhone(@RequestParam String phone) {
        return service.searchByPhone(phone);
    }

    @GetMapping(value = "/search", params = "email")
    public Employee findByEmail(@RequestParam String email) {
        return service.searchByEmail(email);
    }
}