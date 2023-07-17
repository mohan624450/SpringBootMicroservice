package com.mc.training.employeeservice.service;

import com.mc.training.employeeservice.dto.APIResponseDto;
import com.mc.training.employeeservice.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployees();

    APIResponseDto getEmployeeById(Long id);
}
