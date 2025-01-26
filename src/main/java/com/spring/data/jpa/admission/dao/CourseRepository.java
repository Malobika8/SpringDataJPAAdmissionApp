package com.spring.data.jpa.admission.dao;

import com.spring.data.jpa.admission.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    public Page<Course> findByTitleContaining(String title, PageRequest pageRequest);
}
