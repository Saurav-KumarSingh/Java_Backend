package com.example.spring.data.jpa.repository;


import com.example.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String name);


    /// JPQL Query
    @Query("select s from Student s where s.emailId=?1")
    public Student findByEmailId(String emailId);
}
