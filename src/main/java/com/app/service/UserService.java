package com.app.service;

import com.app.models.user.dto.UserDto;

import java.util.Optional;

public interface UserService {
    void addOrUpdateUser(UserDto userDto);
    void deleteUser(Long id);
    Optional<UserDto> findById(Long id);
    Optional<UserDto> findByUsername(String username);
}
