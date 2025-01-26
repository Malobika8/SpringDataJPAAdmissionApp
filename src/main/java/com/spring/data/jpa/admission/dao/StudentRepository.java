package com.spring.data.jpa.admission.dao;

import com.spring.data.jpa.admission.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String str);

    public List<Student> findByGuardianName(String name);

    //JPQL Query
    @Query("select s from Student s where s.emailId = ?1")
    public Student getStudentByEmailId(String emailId);

    //JPQL Query
    @Query("select s.firstName from Student s where s.emailId = ?1")
    public String getStudentFirstNameByEmailId(String emailId);

    //Native Query
    @NativeQuery("select * from Student s where s.emailId = ?1")
    public Student getStudentByEmailIdNative(String emailId);

    //Native Query
    @NativeQuery("select * from Student s where s.emailId = :emailId")
    public Student getStudentByEmailIdNativeNamedParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @NativeQuery("update Student set firstName = :firstName where emailId = :emailId")
    public int updateStudentFirstNameByEmailId(String firstName, String emailId);
}
