package com.fatih.springboot.controller;

import com.fatih.springboot.entity.Department;
import com.fatih.springboot.handling.DepartmentNotFoundException;
import com.fatih.springboot.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private Department department;

    @MockBean
    private DepartmentService service;


    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("ASD")
                .departmentAddress("C-SIDE")
                .departmentCode("422")
                .departmentId(3L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department data = Department.builder()
                .departmentName("ASD")
                .departmentAddress("C-SIDE")
                .departmentCode("422")
                .build();
        Mockito.when(service.saveDepartment(data)).thenReturn(department);

        mockMvc.perform(post("/departments")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
                "    \"departmentName\" : \"CE\",\n" +
                "    \"departmentAddress\" : \"B-SIDE\",\n" +
                "    \"departmentCode\" : \"311\"\n" +
                "}"))
        .andExpect(status().isOk());
    }

    @Test
    void getDataById() throws Exception {
        Mockito.when(service.getDepartmentById(3L))
        .thenReturn(department);

        mockMvc.perform(get("/departments/3")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}