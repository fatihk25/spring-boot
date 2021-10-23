package com.fatih.springboot.controller;

import com.fatih.springboot.entity.Department;
import com.fatih.springboot.handling.DepartmentNotFoundException;
import com.fatih.springboot.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(
            @Valid @RequestBody Department department) {
        return service.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartmentData() {
        LOGGER.info("Log in get department data");
        return service.getAllDepartmentData();
    }

    @GetMapping("/departments/{id}")
    public Department getDataById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return service.getDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDataById(@PathVariable("id") Long departmentId) {
        service.deleteDataById(departmentId);
        return "Data deleted";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department) {
        return service.updateData(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName) {
        return service.getDepartmentByName(departmentName);
    }
}
