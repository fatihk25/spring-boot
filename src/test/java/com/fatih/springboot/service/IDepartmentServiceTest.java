package com.fatih.springboot.service;

import com.fatih.springboot.entity.Department;
import com.fatih.springboot.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IDepartmentServiceTest {

    @Autowired
    private DepartmentService service;

    @MockBean
    private DepartmentRepository repository;

    @BeforeEach
//    @BeforeAll
    void setUp() {
        Department department =
                Department.builder()
                        .departmentId(3L)
                        .departmentName("DS")
                        .departmentAddress("D-SIDE")
                        .departmentCode("511")
                        .build();
        Mockito.when(repository.
                findDepartmentByDepartmentNameIgnoringCase("DS"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Testing Data by Department Name")
    public void validationDepartmentName() {
        String name = "DS";
        Department getData = service.getDepartmentByName(name);

        assertEquals(name, getData.getDepartmentName());
    }
}