package com.mc.training.departmentservice.service;

import com.mc.training.departmentservice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentServie {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    List<DepartmentDto> getAllDepartments();

    DepartmentDto getDepartmentByid(Long id);

    DepartmentDto getDepartmentByCode(String dCode);
}
