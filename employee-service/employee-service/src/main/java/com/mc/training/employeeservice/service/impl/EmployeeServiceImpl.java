package com.mc.training.employeeservice.service.impl;

import com.mc.training.employeeservice.dto.APIResponseDto;
import com.mc.training.employeeservice.dto.DepartmentDto;
import com.mc.training.employeeservice.dto.EmployeeDto;
import com.mc.training.employeeservice.entity.Employee;
import com.mc.training.employeeservice.repository.EmployeeRepository;
import com.mc.training.employeeservice.service.APIClient;
import com.mc.training.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    //private RestTemplate restTemplate;

    // private WebClient webClient;
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        return modelMapper.map(employeeRepository.save(modelMapper.map(employeeDto, Employee.class)), EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream().map(employee -> modelMapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();

        //ResponseEntity<DepartmentDto> entity = restTemplate.getForEntity("http://localhost:8091/api/departments/deptCode/" + employee.getDepartmentCode(), DepartmentDto.class);

//        APIResponseDto apiResponseDto = new APIResponseDto();
//        apiResponseDto.setEmployeeDto(modelMapper.map(employeeRepository.findById(id), EmployeeDto.class));
//        apiResponseDto.setDepartmentDto(entity.getBody());
//        return apiResponseDto;

//        DepartmentDto departmentDto =webClient.get()
//                .uri("http://localhost:8091/api/departments/deptCode/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();
//        System.out.println(departmentDto);
//        APIResponseDto apiResponseDto = new APIResponseDto();
//        apiResponseDto.setEmployeeDto(modelMapper.map(employeeRepository.findById(id), EmployeeDto.class));
//        apiResponseDto.setDepartmentDto(departmentDto);

        DepartmentDto departmentDto = apiClient.getDepartmentDeptCode(employee.getDepartmentCode());
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(modelMapper.map(employeeRepository.findById(id), EmployeeDto.class));
        apiResponseDto.setDepartmentDto(departmentDto);


        return apiResponseDto;
    }
}


