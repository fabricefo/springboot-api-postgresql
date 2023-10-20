package com.fabricefo.springbootapijpa.service;

import com.fabricefo.springbootapijpa.dto.request.EmployeeRequest;
import com.fabricefo.springbootapijpa.dto.response.EmployeeResponse;
import com.fabricefo.springbootapijpa.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeEntity> findAllEmployee();
    Optional<EmployeeEntity> findById(Long id);
    EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);
    EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);
    void deleteEmployee(Long id);

//    Using Request for Save and Update Employee
    EmployeeResponse saveEmployee(EmployeeRequest employeeRequest);
    EmployeeResponse updateEmployee(EmployeeRequest employeeRequest, Long id);


}