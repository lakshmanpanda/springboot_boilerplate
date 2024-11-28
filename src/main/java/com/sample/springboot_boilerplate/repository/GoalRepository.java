package com.sample.springboot_boilerplate.repository;

import com.sample.springboot_boilerplate.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer> {
    Optional<Goal> findByGoalRef(String goalRef);
}
