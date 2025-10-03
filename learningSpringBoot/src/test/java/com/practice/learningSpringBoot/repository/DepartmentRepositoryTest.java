package com.practice.learningSpringBoot.repository;

import com.practice.learningSpringBoot.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void whenFindById_thenReturnDepartment(){
        Department department = Department.builder()
                .departmentName("CSE")
                .departmentAddress("SVIET")
                .departmentCode("BTCS")
                .build();

        Department savedDepartment = testEntityManager.persistAndFlush(department);

        Department found = departmentRepository.findById(savedDepartment.getDepartmentId()).get();

        assertEquals("CSE", found.getDepartmentName());
    }
}