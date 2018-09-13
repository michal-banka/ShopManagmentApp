package com.app.models.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String email;
    private boolean isActive;
    private LocalDate expirationDate;
    @Enumerated(EnumType.STRING)
    private Role role;
}
