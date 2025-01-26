package com.spring.data.jpa.admission.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course")
@Entity
public class CourseMaterial {

    @SequenceGenerator(name = "courseMaterialId_sequence",
            sequenceName = "courseMaterialId_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "courseMaterialId_sequence")
    @Id
    long courseMaterialId;
    String url;

    @OneToOne(mappedBy = "courseMaterial", fetch = FetchType.LAZY)
    Course course;
}
