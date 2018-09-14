package com.app.models.user.dto;

import com.app.models.user.User;
import org.springframework.stereotype.Component;

@Component
public class ConverterDto {

    public UserDto userToUserDto(User user)
    {

        return user == null ? null : new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                "",
                user.getEmail(),
                user.isActive(),
                user.getRole(),
                user.getCustomer()
        );
    }

    public User userDtoToUser(UserDto userDto)
    {
        return userDto == null ? null : new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getEmail(),
                userDto.isActive(),
                userDto.getRole(),
                userDto.getCustomer()
        );
    }
}
