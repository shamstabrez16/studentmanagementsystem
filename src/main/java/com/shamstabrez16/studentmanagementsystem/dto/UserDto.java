package com.shamstabrez16.studentmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String email;
    private String secretkey;

    public UserDto(Long id, String email) {
    }
}
