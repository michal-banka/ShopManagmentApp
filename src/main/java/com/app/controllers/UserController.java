package com.app.controllers;

import com.app.models.Role;
import com.app.models.dto.UserDto;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/register")
    public String userRegisterGet(Model model){
        model.addAttribute("user", new UserDto());
        model.addAttribute("roles", Role.values());
        //for validation
        model.addAttribute("errors", new HashMap<>());
        return "user/register";
    }

    @PostMapping("/register")
    public String userRegisterPost( @Valid @ModelAttribute UserDto userDto,
                                    BindingResult bindingResult,
                                    Model model){
        if (bindingResult.hasErrors())
        {
            Map<String,String> errors =
                    bindingResult
                    .getFieldErrors()
                    .stream()
                    .collect(Collectors.toMap(FieldError::getField, FieldError::getCode));
            model.addAttribute("user", userDto);
            model.addAttribute("roles", Role.values());
            model.addAttribute("errors", errors);
            return "user/register";
        }

        userDto.setPassword();
    }
}
