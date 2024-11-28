package com.sample.springboot_boilerplate.repository;

import com.sample.springboot_boilerplate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByMailId(String email);
}
