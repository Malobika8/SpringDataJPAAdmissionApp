package com.spring.data.jpa.admission.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString(exclude = "courseMaterial")
public class Course {

    @SequenceGenerator(name = "courseId_sequence",
            sequenceName = "courseId_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "courseId_sequence")
    @Id
    long courseId;
    String title;
    int credit;

    @OneToOne
    @JoinColumn(name = "courseMaterialId", referencedColumnName = "courseMaterialId")
    @Cascade(CascadeType.ALL)
    CourseMaterial courseMaterial;

    @ManyToOne
    @JoinColumn(name = "teacherId", referencedColumnName = "teacherId")
    @Cascade(CascadeType.ALL)
    Teacher teacher;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "courseId", referencedColumnName = "courseId"),
            inverseJoinColumns = @JoinColumn(name = "studentId", referencedColumnName = "studentId"))
    @Cascade(CascadeType.ALL)
    List<Student> studentList;
}
