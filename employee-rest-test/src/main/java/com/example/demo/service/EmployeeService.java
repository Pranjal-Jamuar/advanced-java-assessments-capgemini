package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Employee getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Employee> searchByName(String name) {
        return repository.findByName(name);
    }

    public List<Employee> searchByDepartment(String department) {
        return repository.findByDepartment(department);
    }

    public Employee searchByPhone(String phone) {
        return repository.findByPhone(phone);
    }

    public Employee searchByEmail(String email) {
        return repository.findByEmail(email);
    }
}