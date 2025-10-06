package com.example.spring.data.jpa.repository;


import com.example.spring.data.jpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String name);


    /// JPQL Query
    @Query("select s from Student s where s.emailId=?1")
    public Student findByEmailId(String emailId);


    /// Native Query
    @Query(
            value = "SELECT * FROM student_tbl WHERE guardian_email = ?1",
            nativeQuery = true
    )
    List<Student> findByGuardianEmail(String guardianEmail);

    /// Native named Query
    @Query(
            value = "SELECT * FROM student_tbl s WHERE s.email = :email",
            nativeQuery = true
    )
    Student findByStudentEmailNativeNamedParam(@Param("email") String email);


     /// Update student by Native query
     @Modifying
     @Transactional
    @Query(
            value = "UPDATE  student_tbl s set first_name=?1 WHERE s.email = ?2",
            nativeQuery = true
    )
   void updateStudentFirstNameByEmailId(String firstName, String emailId);





}
