package com.fabricefo.springbootapijpa.dto.mapper;

import com.fabricefo.springbootapijpa.dto.request.EmployeeRequest;
import com.fabricefo.springbootapijpa.dto.response.EmployeeResponse;
import com.fabricefo.springbootapijpa.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);
    EmployeeEntity fromRequestToEntity(EmployeeRequest employeeRequest);
    EmployeeResponse fromEntityToResponse(EmployeeEntity employeeEntity);
}
