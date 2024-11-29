package com.sample.springboot_boilerplate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "user_name", nullable = false, length = 255)
    private String userName;

    @Column(name = "rollno", nullable = false, unique = true, length = 10)
    private String rollNo;

    @Column(name = "mail_id", nullable = false, unique = true, length = 255)
    private String mailId;

    @Column(name = "pass", nullable = false, length = 255)
    private String password;

    @Column(name = "user_status", nullable = false, length = 25)
    private String userStatus;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "user_role", nullable = false, length = 255)
    private String userRole;
}
