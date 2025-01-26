package com.spring.data.jpa.admission.dao;

import com.spring.data.jpa.admission.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
