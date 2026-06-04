package com.example.securityApplication.SecurityApp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignUpDTO {
    @NotBlank(message = "Email required")
    @Email(message = "Invalid email format")
    String email;

    @NotBlank(message = "password required")
    String password;

    @NotBlank (message = "Name required")
    String name;
}
