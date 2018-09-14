package com.app.controllers;

import com.app.models.user.Role;
import com.app.models.user.dto.UserDto;
import com.app.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserService userService;

    public UserController(BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
    }

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

        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userService.addOrUpdateUser(userDto);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model)
    {
        model.addAttribute("error", "");
        return "user/login";
    }

    @GetMapping("/login/error")
    public String loginError(Model model)
    {
        model.addAttribute("error", "Logging error!");
        return "user/login";
    }
}
