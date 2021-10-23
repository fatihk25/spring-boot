package com.fatih.springboot.service;

import com.fatih.springboot.entity.Department;
import com.fatih.springboot.handling.DepartmentNotFoundException;

import java.util.List;

public interface IDepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getAllDepartmentData();

    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDataById(Long departmentId);

    public Department updateData(Long departmentId, Department department);

    public Department getDepartmentByName(String departmentName);
}
