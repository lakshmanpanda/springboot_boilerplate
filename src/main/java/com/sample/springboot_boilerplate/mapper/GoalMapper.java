package com.sample.springboot_boilerplate.mapper;

import com.sample.springboot_boilerplate.dto.GoalsDTO;
import com.sample.springboot_boilerplate.entity.Goal;
import org.springframework.stereotype.Component;

@Component
public class GoalMapper {

    public GoalsDTO mapToDto(Goal goal) {
        return new GoalsDTO(
                goal.getGid(),
                goal.getGoalTitle(),
                goal.getGoalDesc(),
                goal.getAssignedTo().getId(),
                goal.getCreatedBy().getId(),
                goal.getGoalStartDate(),
                goal.getGoalEndDate(),
                goal.getGoalCreatedDate(),
                goal.getGoalUpdatedDate(),
                goal.getGoalType(),
                goal.getGoalStatus(),
                goal.getGoalPriority(),
                goal.getGoalRef()
        );
    }

    public Goal mapToEntity(GoalsDTO goalsDTO) {
        Goal goal = new Goal();
        goal.setGoalTitle(goalsDTO.getGoalTitle());
        goal.setGoalDesc(goalsDTO.getGoalDesc());
        // You'll need to fetch User entities based on the IDs provided in DTO
        // Assuming you have a service layer to handle fetching User by ID
        // For example:
        // goal.setAssignedTo(userRepository.findById(goalsDTO.getAssignedTo()).orElse(null));
        // goal.setCreatedBy(userRepository.findById(goalsDTO.getCreatedBy()).orElse(null));
        goal.setGoalStartDate(goalsDTO.getGoalStartDate());
        goal.setGoalEndDate(goalsDTO.getGoalEndDate());
        goal.setGoalCreatedDate(goalsDTO.getGoalCreatedDate());
        goal.setGoalUpdatedDate(goalsDTO.getGoalUpdatedDate());
        goal.setGoalType(goalsDTO.getGoalType());
        goal.setGoalStatus(goalsDTO.getGoalStatus());
        goal.setGoalPriority(goalsDTO.getGoalPriority());
        goal.setGoalRef(goalsDTO.getGoalRef());
        return goal;
    }
}
