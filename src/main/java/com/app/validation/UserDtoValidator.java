package com.app.validation;

import com.app.models.user.dto.UserDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserDtoValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        //pick class that is used in this validator
        return aClass.equals(UserDto.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDto userDto = (UserDto)o;

        if (!userDto.getPassword().equals(userDto.getPasswordConfirmation()))
        {
            errors.rejectValue("passwordConfirmation", "Given passwords are not the same!");
        }
    }
}
