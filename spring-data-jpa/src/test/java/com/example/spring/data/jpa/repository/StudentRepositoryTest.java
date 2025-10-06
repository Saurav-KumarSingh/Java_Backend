package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Guardian;
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
//                .guardianName("Ravindra Singh")
//                .guardianMobile("9158346285")
//                .guardianEmail("ravindra@gmail.com")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian=Guardian.builder()
                .name("Ravindra Singh")
                .email("ravindra@gmail.com")
                .mobile("9158346285")
                .build();

        Student student=Student.builder()
                .emailId("shivam@gmail.com")
                .firstName("Shivam")
                .lastName("Singh")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList=studentRepository.findAll();

        System.out.println(studentList);
    }

 @Test
    public void printAllStudentByFirstName(){
        List<Student> studentList=studentRepository.findByFirstName("Saurav");

        System.out.println(studentList);
    }

    @Test
    public void printAllStudentByFirstNameContaining(){
        List<Student> studentList=studentRepository.findByFirstNameContaining("S");

        System.out.println(studentList);
    }
    @Test
    public void printAllStudentByEmailId(){
        Student student=studentRepository.findByEmailId("saurav@gmail.com");

        System.out.println(student);
    }

    @Test
    public void printAllStudentByGuardianEmail(){
        List<Student> studentList=studentRepository.findByGuardianEmail("ravindra@gmail.com");

        System.out.println(studentList);
    }



}