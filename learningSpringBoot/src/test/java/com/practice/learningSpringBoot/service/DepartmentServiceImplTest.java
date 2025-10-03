package com.practice.learningSpringBoot.service;

import com.practice.learningSpringBoot.entity.Department;
import com.practice.learningSpringBoot.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceImplTest {

    @Autowired
    private DepartmentService departmentService;

    @MockitoBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department=Department.builder().departmentName("CSE")
                .departmentAddress("SVIET")
                .departmentCode("BTCS")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentName("CSE"))
                .thenReturn(department);
    }

    @Test
//    @Disabled  //used to disable test case
    public void whenValidDepartmentNameThenDepartmentShouldFound(){
        String departmentName="CSE";
        Department found=departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName,found.getDepartmentName());
    }
}