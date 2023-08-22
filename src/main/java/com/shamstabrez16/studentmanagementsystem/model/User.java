package com.shamstabrez16.studentmanagementsystem.model;

import lombok.*;

import javax.persistence.*;


@Builder
@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String email;
    private String secretkey;
}
