package com.fabricefo.springbootapijpa.controller;

import com.fabricefo.springbootapijpa.dto.request.EmployeeRequest;
import com.fabricefo.springbootapijpa.dto.response.EmployeeResponse;
import com.fabricefo.springbootapijpa.entity.EmployeeEntity;
import com.fabricefo.springbootapijpa.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeEntity> findAllEmployee() {
        return employeeService.findAllEmployee();
    }

    @GetMapping("/{id}")
    public Optional<EmployeeEntity> findEmployeeById(@PathVariable("id") Long id) {
        return employeeService.findById(id);
    }

    @PostMapping
    public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.saveEmployee(employeeEntity);
    }

    @PutMapping
    public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.updateEmployee(employeeEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }

//    Using Request and Response with save and update employee

    @PostMapping("/res")
    public EmployeeResponse saveEmpResponse(@RequestBody EmployeeRequest employeeRequest) {
        return employeeService.saveEmployee(employeeRequest);
    }

    @PutMapping("/res/{id}")
    public EmployeeResponse updateEmpResponse(@RequestBody EmployeeRequest employeeRequest, @PathVariable("id") Long id) {
        return employeeService.updateEmployee(employeeRequest, id);
    }

}