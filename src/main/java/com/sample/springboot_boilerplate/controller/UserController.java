package com.sample.springboot_boilerplate.controller;

import com.sample.springboot_boilerplate.dto.UserDTO;
import com.sample.springboot_boilerplate.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public UserDTO login(@RequestParam("email") String email, @RequestParam("password") String password) {
        return userService.login(email, password);
    }
}
