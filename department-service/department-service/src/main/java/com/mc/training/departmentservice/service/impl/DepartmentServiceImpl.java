package com.mc.training.departmentservice.service.impl;

import com.mc.training.departmentservice.dto.DepartmentDto;
import com.mc.training.departmentservice.entity.Department;
import com.mc.training.departmentservice.respository.DepartmentRepository;
import com.mc.training.departmentservice.service.DepartmentServie;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentServie {

    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;



    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = modelMapper.map(departmentDto, Department.class);
        Department saved = departmentRepository.save(department);
        return modelMapper.map(saved,DepartmentDto.class);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(department -> modelMapper.map(department,DepartmentDto.class)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto getDepartmentByid(Long id) {
        Department department = departmentRepository.findById(id).get();
        return modelMapper.map(department,DepartmentDto.class);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String dCode) {
        return modelMapper.map(departmentRepository.findByDepartmentCode(dCode),DepartmentDto.class);
    }

}
