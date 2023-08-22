package com.shamstabrez16.studentmanagementsystem.model;


import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Table(name = "students")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstName;
    private String lastName;

}
