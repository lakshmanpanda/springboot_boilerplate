package com.sample.springboot_boilerplate.service;

import com.sample.springboot_boilerplate.dto.GoalsDTO;
import com.sample.springboot_boilerplate.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO login(String email, String password);

    List<GoalsDTO> getGoal(Integer id);
}
