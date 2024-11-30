package com.sample.springboot_boilerplate.repository;

import com.sample.springboot_boilerplate.entity.Goals;
import com.sample.springboot_boilerplate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoalRepository extends JpaRepository<Goals, Integer> {
    @Query(value = "SELECT * FROM goals WHERE assigned_to = :assignedTo", nativeQuery = true)
    List<Goals> findAllByAssignedTo(@Param("assignedTo") Integer assignedTo);
}

