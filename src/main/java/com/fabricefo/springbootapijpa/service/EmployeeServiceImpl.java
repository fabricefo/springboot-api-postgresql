package com.fabricefo.springbootapijpa.service;

import com.fabricefo.springbootapijpa.dto.mapper.EmployeeMapper;
import com.fabricefo.springbootapijpa.dto.request.EmployeeRequest;
import com.fabricefo.springbootapijpa.dto.response.EmployeeResponse;
import com.fabricefo.springbootapijpa.entity.EmployeeEntity;
import com.fabricefo.springbootapijpa.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeEntity> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<EmployeeEntity> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

//    Using Request and Response with save and update employee

    @Override
    public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest) {
        EmployeeEntity employeeEntity = EmployeeMapper.MAPPER.fromRequestToEntity(employeeRequest);
        employeeRepository.save(employeeEntity);
        return EmployeeMapper.MAPPER.fromEntityToResponse(employeeEntity);
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeRequest employeeRequest, Long id) {

        Optional<EmployeeEntity> checkExistingEmployee = findById(id);
        if (! checkExistingEmployee.isPresent())
            throw new RuntimeException("Employee Id "+ id + " Not Found!");

        EmployeeEntity employeeEntity = EmployeeMapper.MAPPER.fromRequestToEntity(employeeRequest);
        employeeEntity.setId(id);
        employeeRepository.save(employeeEntity);
        return EmployeeMapper.MAPPER.fromEntityToResponse(employeeEntity);
    }

}
