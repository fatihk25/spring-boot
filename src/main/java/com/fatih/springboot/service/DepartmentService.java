package com.fatih.springboot.service;

import com.fatih.springboot.entity.Department;
import com.fatih.springboot.handling.DepartmentNotFoundException;
import com.fatih.springboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private DepartmentRepository repository;

    @Override
    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    @Override
    public List<Department> getAllDepartmentData() {
        return repository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = repository.findById(departmentId);

        if(!department.isPresent()) {
            throw new DepartmentNotFoundException("Department not found");
        }
        return department.get();
    }

    @Override
    public void deleteDataById(Long departmentId) {
        repository.deleteById(departmentId);
    }

    @Override
    public Department updateData(Long departmentId, Department department) {
        Department data = repository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(department.getDepartmentName()) ) {
            data.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode()) ) {
            data.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress()) ) {
            data.setDepartmentAddress(department.getDepartmentAddress());
        }

        return repository.save(data);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
//        return repository.findDepartmentByDepartmentName(departmentName);
        return repository.findDepartmentByDepartmentNameIgnoringCase(departmentName);
    }
}
