package com.spring.data.jpa.admission.dao;

import com.spring.data.jpa.admission.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Integer> {
}
