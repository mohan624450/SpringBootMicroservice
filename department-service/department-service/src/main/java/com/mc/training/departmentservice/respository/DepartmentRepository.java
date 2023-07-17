package com.mc.training.departmentservice.respository;


import com.mc.training.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

   Department findByDepartmentCode(String code);
}
