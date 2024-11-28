package com.sample.springboot_boilerplate.service;

import com.sample.springboot_boilerplate.dto.UserDTO;

public interface UserService {
    UserDTO login(String email, String password);
}
