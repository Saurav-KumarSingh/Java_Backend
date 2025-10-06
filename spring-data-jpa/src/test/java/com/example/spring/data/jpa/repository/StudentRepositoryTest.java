package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student  student=Student.builder()
                .emailId("saurav@gmail.com")
                .firstName("Saurav")
                .lastName("Singh")
                .guardianName("Ravindra Singh")
                .guardianMobile("9158346285")
                .guardianEmail("ravindra@gmail.com")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList=studentRepository.findAll();

        System.out.println(studentList);
    }

}