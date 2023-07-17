package com.mc.training.departmentservice.controller;

import com.mc.training.departmentservice.dto.DepartmentDto;
import com.mc.training.departmentservice.service.DepartmentServie;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentServie departmentServie;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto departmentDto1 = departmentServie.saveDepartment(departmentDto);
        return new ResponseEntity<>(departmentDto1, HttpStatus.CREATED);
    }

    @GetMapping("deptId/{dept-id}")
    public ResponseEntity<DepartmentDto> getDepartmentID(@PathVariable("dept-id") Long id){
        DepartmentDto departmentByid = departmentServie.getDepartmentByid(id);

        return new ResponseEntity<>(departmentByid,HttpStatus.OK);
    }

    @GetMapping("deptCode/{dept-code}")
    public ResponseEntity<DepartmentDto> getDepartmentDeptCode(@PathVariable("dept-code") String dCode){
        DepartmentDto departmentByid = departmentServie.getDepartmentByCode(dCode);
        return new ResponseEntity<>(departmentByid,HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        List<DepartmentDto> allDepartments = departmentServie.getAllDepartments();
        return new ResponseEntity<>(allDepartments,HttpStatus.OK);
    }
 }
