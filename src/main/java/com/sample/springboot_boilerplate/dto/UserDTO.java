package com.sample.springboot_boilerplate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String userName;
    private String password;
    private String rollNo;
    private String mailId;
    private String userStatus;
    private LocalDate createdDate;
    private String userRole;
}
