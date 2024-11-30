package com.sample.springboot_boilerplate.mapper;

import com.sample.springboot_boilerplate.dto.GoalsDTO;
import com.sample.springboot_boilerplate.entity.Goals;
import org.springframework.stereotype.Component;

@Component
public class GoalMapper {

    public GoalsDTO mapToDto(Goals goal) {
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



    public Goals mapToEntity(GoalsDTO goalsDTO) {
        Goals goal = new Goals();
        goal.setGid(goalsDTO.getGid());
        goal.setGoalTitle(goalsDTO.getGoalTitle());
        goal.setGoalDesc(goalsDTO.getGoalDesc());
//        goal.setAssignedTo(goalsDTO.getAssignedTo());
//        goal.setCreatedBy(goalsDTO.getCreatedBy());
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
