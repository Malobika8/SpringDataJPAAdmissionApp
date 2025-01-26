package com.spring.data.jpa.admission.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
@ToString
public class Guardian {
    String name;
    String email;
    String mobile;
}
