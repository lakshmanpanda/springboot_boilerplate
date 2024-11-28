package com.sample.springboot_boilerplate.controller;

import com.sample.springboot_boilerplate.dto.UserDTO;
import com.sample.springboot_boilerplate.exception.InvalidCredentialsException;
import com.sample.springboot_boilerplate.exception.ResourceNotFoundException;
import com.sample.springboot_boilerplate.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestParam("email") String email, @RequestParam("password") String password) {
        try {
            UserDTO userDTO = userService.login(email, password);
            return ResponseEntity.ok(userDTO); // 200 OK
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // 404 Not Found
        } catch (InvalidCredentialsException e) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED); // 401 Unauthorized
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // 500 Internal Server Error
        }
    }
}
