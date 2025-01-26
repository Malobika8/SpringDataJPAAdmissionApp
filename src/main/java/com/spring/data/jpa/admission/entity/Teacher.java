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
public class Teacher {

    @SequenceGenerator(name = "teacherId_sequence",
            sequenceName = "teacherId_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "teacherId_sequence")
    @Id
    long teacherId;
    String firstName;
    String lastName;

//    @OneToMany
//    @Cascade(CascadeType.ALL)
//    @JoinColumn(name = "teacherId", referencedColumnName = "teacherId")
//    List<Course> courseList;
}
