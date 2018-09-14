package com.app.models.user.dto;

import com.app.models.utility.Customer;
import com.app.models.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String passwordConfirmation;
    private String email;
    private boolean isActive;
    private Role role;
    private Customer customer;
}
