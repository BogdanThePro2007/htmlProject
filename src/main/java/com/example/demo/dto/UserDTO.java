package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class UserDTO {
    private Long id;
    private String email;
    private String password;
}
