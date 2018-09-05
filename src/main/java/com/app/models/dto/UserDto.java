package com.app.models.dto;

import com.app.models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String passwordConfirmation;
    private boolean isActive;
    private LocalDate expirationDate;
    private Role role;
}
