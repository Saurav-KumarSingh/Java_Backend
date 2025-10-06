package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Course;
import com.example.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course courseDBA=Course.builder()
                .title("DBA")
                .credit(4)
                .build();

        Course courseCSE=Course.builder()
                .title("CSE")
                .credit(4)
                .build();

        Teacher teacher=Teacher.builder()
                .firstName("SK")
                .lastName("Singh")
//                .courses(List.of(courseDBA,courseCSE))
                .build();

        teacherRepository.save(teacher);
    }
}