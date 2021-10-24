package com.fatih.springboot.repository;

import com.fatih.springboot.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("ET")
                .departmentAddress("K-SIDE")
                .departmentCode("411")
                .build();

        entityManager.persist(department);
    }

    @Test
    public void getDepartment() {
        Department department = repository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "ET");
    }


}