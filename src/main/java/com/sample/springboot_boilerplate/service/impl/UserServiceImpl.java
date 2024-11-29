package com.sample.springboot_boilerplate.service.impl;

import com.sample.springboot_boilerplate.db.UserHandler;
import com.sample.springboot_boilerplate.dto.GoalsDTO;
import com.sample.springboot_boilerplate.dto.TasksDTO;
import com.sample.springboot_boilerplate.dto.UserDTO;
import com.sample.springboot_boilerplate.entity.User;
import com.sample.springboot_boilerplate.exception.InvalidCredentialsException;
import com.sample.springboot_boilerplate.exception.ResourceNotFoundException;
import com.sample.springboot_boilerplate.mapper.UserMapper;
import com.sample.springboot_boilerplate.repository.UserRepository;
import com.sample.springboot_boilerplate.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final UserHandler userHandler;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, UserHandler userHandler) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userHandler = userHandler;
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
        List<Object[]> goals = userHandler.getGoal(id);
        List<GoalsDTO> goals_list = new ArrayList<>();

        for  (Object[] goal : goals) {
            GoalsDTO dto = new GoalsDTO();
            dto.setGid(Integer.parseInt(Objects.toString(goal[0])));
            dto.setGoalTitle((String) goal[1]);
            dto.setGoalDesc((String) goal[2]);
            dto.setAssignedTo(Integer.parseInt(Objects.toString(goal[3])));
            dto.setCreatedBy(Integer.parseInt(Objects.toString(goal[4])));
            dto.setGoalStartDate((Date) goal[5]);
            dto.setGoalEndDate((Date) goal[6]);
            dto.setGoalCreatedDate((Date) goal[7]);
            dto.setGoalUpdatedDate((Date) goal[8]);
            dto.setGoalType((String) goal[9]);
            dto.setGoalStatus((String) goal[10]);
            dto.setGoalPriority(Integer.parseInt(Objects.toString(goal[11])));
            dto.setGoalRef((String) goal[12]);
            goals_list.add(dto);
        }

        return goals_list;
    }

    @Override
    public List<TasksDTO> getTaskList(Integer id, Integer gid) {
        List<Object[]> tasks = userHandler.getTaskList(id, gid);
        List<TasksDTO> taskList = new ArrayList<>();

        for (Object[] task : tasks) {
            TasksDTO dto = new TasksDTO();
            dto.setTid(Integer.parseInt(Objects.toString(task[0])));
            dto.setTaskTitle((String) task[1]);
            dto.setCreatedBy(Integer.parseInt(Objects.toString(task[2])));
            dto.setAssignedTo(Integer.parseInt(Objects.toString(task[3])));
            dto.setTaskStartDate((Date) task[4]);
            dto.setTaskEndDate((Date) task[5]);
            dto.setTaskCreatedDate((Date) task[6]);
            dto.setTaskUpdatedDate((Date) task[7]);
            dto.setTaskStatus((String) task[8]);
            dto.setTaskDesc((String) task[9]);
            dto.setTaskPriority(Integer.parseInt(Objects.toString(task[10])));
            dto.setTaskRef((String) task[11]);
            dto.setGid(task[12] != null ? Integer.parseInt(Objects.toString(task[12])) : null);
            taskList.add(dto);
        }

        return taskList;
    }

}
