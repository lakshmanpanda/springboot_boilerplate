package com.sample.springboot_boilerplate.service.impl;

import com.sample.springboot_boilerplate.dto.GoalsDTO;
import com.sample.springboot_boilerplate.dto.UserDTO;
import com.sample.springboot_boilerplate.entity.User;
import com.sample.springboot_boilerplate.exception.InvalidCredentialsException;
import com.sample.springboot_boilerplate.exception.ResourceNotFoundException;
import com.sample.springboot_boilerplate.mapper.UserMapper;
import com.sample.springboot_boilerplate.repository.UserRepository;
import com.sample.springboot_boilerplate.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO login(String email, String password) {
        // Check if user exists by email
        User user = userRepository.findByMailId(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));

        // Check if the password matches
        if (!user.getPassword().equals(password)) {
            throw new InvalidCredentialsException("Invalid credentials");
        }

        // Return user DTO if credentials are valid
        return userMapper.mapToDto(user);
    }

    @Override
    public List<GoalsDTO> getGoal(Integer id) {
        return null;
    }
}
