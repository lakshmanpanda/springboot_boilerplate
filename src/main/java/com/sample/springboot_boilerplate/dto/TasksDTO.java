package com.sample.springboot_boilerplate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TasksDTO {
    private Integer tid;
    private String taskTitle;
    private Integer createdBy;
    private Integer assignedTo;
    private Date taskStartDate;
    private Date taskEndDate;
    private Date taskCreatedDate;
    private Date taskUpdatedDate;
    private String taskStatus;
    private String taskDesc;
    private Integer taskPriority;
    private String taskRef;
    private Integer gid; // Foreign key reference to Goals
}
