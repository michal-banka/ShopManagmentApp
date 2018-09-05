package com.app.models.dto;

import com.app.models.User;
import org.springframework.stereotype.Component;

@Component
public class ConverterDto {

    public UserDto userToUserDto(User user){
        if (user != null)
        {
            return new UserDto(
                    user.getId(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getPassword(),
                    "",
                    user.isActive(),
                    user.getExpirationDate(),
                    user.getRole()
            );
        }
        return null;
    }

    public User userDtoToUser(UserDto userDto)
    {
        if (userDto != null) {
            return new User(
                    userDto.getId(),
                    userDto.getUsername(),
                    userDto.getEmail(),
                    userDto.getPassword(),
                    userDto.isActive(),
                    userDto.getExpirationDate(),
                    userDto.getRole()
            );
        }
        return null;
    }
}
