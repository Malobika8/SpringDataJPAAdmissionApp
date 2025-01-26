package com.spring.data.jpa.admission.test;

import com.spring.data.jpa.admission.dao.TeacherRepository;
import com.spring.data.jpa.admission.entity.Course;
import com.spring.data.jpa.admission.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TeacherTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course course = Course.builder()
                .title("DBMS")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Ruparna")
                .lastName("Ganguly")
                //.courseList(List.of(course))
                .build();

        teacherRepository.save(teacher);
    }
}
