package com.spring.data.jpa.admission.test;

import com.spring.data.jpa.admission.dao.CourseMaterialRepository;
import com.spring.data.jpa.admission.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseMaterialTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void getCourseMaterial(){
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
        System.out.println(courseMaterialList);
        System.out.println(courseMaterialList.get(0).getCourse().getTitle());
    }
}
