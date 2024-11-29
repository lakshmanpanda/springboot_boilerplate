package com.sample.springboot_boilerplate.controller;

import com.sample.springboot_boilerplate.dto.GoalsDTO;
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

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam("email") String email, @RequestParam("password") String password) {
        try {
            UserDTO userDTO = userService.login(email, password);
//            userDTO.getId()
            return ResponseEntity.ok(userDTO); // 200 OK
        } catch (ResourceNotFoundException e) {
            // Return 404 with error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found with email: " + email);
        } catch (InvalidCredentialsException e) {
            // Return 401 with error message
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid credentials provided");
        } catch (Exception e) {
            // Return 500 with generic error message
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error");
        }
    }

    @GetMapping("/Dashboard/{id}")
    public ResponseEntity<List<GoalsDTO>> getGoal(@RequestParam("id") Integer id) {
        List<GoalsDTO> goals = userService.getGoal(id);
        return ResponseEntity.ok(goals);
    }
}
