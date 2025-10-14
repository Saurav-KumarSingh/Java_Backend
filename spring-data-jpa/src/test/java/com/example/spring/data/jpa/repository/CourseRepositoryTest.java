package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Course;
import com.example.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourses() {
        List<Course> courseList = courseRepository.findAll();
        System.out.println(courseList);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Swati")
                .lastName("Mishra")
                .build();

        Course course = Course.builder()
                .title("SST")
                .credit(4)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        Page<Course> firstPage = courseRepository.findAll(firstPageWithThreeRecords);
        List<Course> firstCourseList = firstPage.getContent();

        System.out.println("First Page Courses: " + firstCourseList);

        Page<Course> secondPage = courseRepository.findAll(secondPageWithTwoRecords);
        List<Course> secondCourseList = secondPage.getContent();

        System.out.println("Second Page Courses: " + secondCourseList);
    }
}
