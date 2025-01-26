package com.spring.data.jpa.admission.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Student {

    @SequenceGenerator(name = "studentId_sequence",
            sequenceName = "studentId_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentId_sequence")
    @Id
    long studentId;

    String firstName;
    String lastName;

    @Column(unique = true)
    String emailId;

    @Embedded
    Guardian guardian;
}
