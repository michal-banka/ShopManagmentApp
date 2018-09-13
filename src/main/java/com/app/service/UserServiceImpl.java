package com.app.service;

import com.app.models.user.dto.ConverterDto;
import com.app.models.user.dto.UserDto;
import com.app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ConverterDto converterDto;

    public UserServiceImpl(UserRepository userRepository, ConverterDto converterDto) {
        this.userRepository = userRepository;
        this.converterDto = converterDto;
    }

    @Override
    public void addOrUpdateUser(UserDto userDto) {
        userRepository.save(converterDto.userDtoToUser(userDto));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return userRepository.findById(id).map(u -> converterDto.userToUserDto(u));
    }

    @Override
    public Optional<UserDto> findByUsername(String username) {
        return Optional.of(converterDto.userToUserDto(userRepository.findByUsername(username)));
    }
}
