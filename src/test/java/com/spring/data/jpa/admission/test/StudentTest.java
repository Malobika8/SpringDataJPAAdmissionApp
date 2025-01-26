package com.spring.data.jpa.admission.test;

import com.spring.data.jpa.admission.dao.StudentRepository;
import com.spring.data.jpa.admission.entity.Guardian;
import com.spring.data.jpa.admission.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {

        Student student = Student.builder()
                .firstName("Naina")
                .lastName("Singh")
                .emailId("naina@gmail.com")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Nitin")
                .email("nitin@gmail.com")
                .mobile("999452617")
                .build();

        Student student = Student.builder()
                .firstName("Mona")
                .lastName("Lisa")
                .emailId("mona@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void getAllStudents() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println(studentList);
    }

    @Test
    public void findStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Mona");
        System.out.println(students);
    }

    @Test
    public void findStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("a");
        System.out.println(students);
    }

    @Test
    public void findStudentByGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Nitin");
        System.out.println(students);
    }

    @Test
    public void getStudentByEmailId() {
        Student student = studentRepository.getStudentByEmailId("mona@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getStudentFirstNameByEmailId() {
        String firstName = studentRepository.getStudentFirstNameByEmailId("mona@gmail.com");
        System.out.println(firstName);
    }

    @Test
    public void getStudentByEmailIdNative() {
        Student student = studentRepository.getStudentByEmailIdNative("mona@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getStudentByEmailIdNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailIdNativeNamedParam("mona@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentFirstNameByEmailId() {
        int ret = studentRepository.updateStudentFirstNameByEmailId("Monalisa", "mona@gmail.com");
        System.out.println(ret);
    }
}
