package com.fatih.springboot.controller;

import com.fatih.springboot.entity.Department;
import com.fatih.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {
        return service.saveDepartment(department);
    }
}
