package com.spring.data.jpa.admission.test;

import com.spring.data.jpa.admission.dao.CourseRepository;
import com.spring.data.jpa.admission.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class CourseTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourse() {
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.dbms.com")
                .build();

        Course course = Course.builder()
                .title("DBMS")
                .credit(5)
                .courseMaterial(courseMaterial)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Pushpa")
                .lastName("Nag")
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.algo.com")
                .build();

        Course course = Course.builder()
                .title("ALGO")
                .credit(6)
                .courseMaterial(courseMaterial)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithTwoRecords = PageRequest.of(0, 2);
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);

        List<Course> courseList1 = courseRepository.findAll(firstPageWithTwoRecords).getContent();
        System.out.println("********************** List1");
        System.out.println(courseList1);

        Page<Course> courseList2 = courseRepository.findAll(firstPageWithThreeRecords);
        System.out.println("********************** List2");
        System.out.println("No of pages: " + courseList2.getTotalPages());
        System.out.println(courseList2.toList());
    }

    //Fetch courses based on title
    @Test
    public void findAllSorting() {
        Sort sort1 = Sort.by("title");
        Pageable firstPageWithTwoRecords = PageRequest.of(0, 2, sort1);

        Page<Course> courseList1 = courseRepository.findAll(firstPageWithTwoRecords);
        System.out.println("********************** List1");
        System.out.println("No of pages: " + courseList1.getTotalPages());
        System.out.println(courseList1.toList());

        Sort sort2 = Sort.by("credit").descending();
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3, sort2);

        Page<Course> courseList2 = courseRepository.findAll(firstPageWithThreeRecords);
        System.out.println("********************** List2");
        System.out.println("No of pages: " + courseList2.getTotalPages());
        System.out.println(courseList2.toList());
    }

    @Test
    public void findByTitleContainingPagingAndSorting() {
        List<Course> list = courseRepository.findByTitleContaining("D", PageRequest.of(0, 4))
                .getContent();

        System.out.println(list);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Guardian guardian = Guardian.builder().name("Ronit").email("ronit@gmail.com").mobile("9999").build();
        Course course = Course.builder()
                .teacher(Teacher.builder().firstName("Poppy").lastName("Poo").build())
                .courseMaterial(CourseMaterial.builder().url("www.rest.com").build())
                .studentList(List.of(Student.builder().firstName("Lipa").lastName("Kr").emailId("lipa@gmail.com")
                        .guardian(guardian).build()))
                .credit(7)
                .title("restAPI")
                .build();

        courseRepository.save(course);
    }
}
