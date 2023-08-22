package com.shamstabrez16.studentmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class StudentDto {
        private Long id;
        private String firstName;
        private String lastName;

    }

