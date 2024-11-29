package com.sample.springboot_boilerplate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoalsDTO {
    private Integer gid;
    private String goalTitle;
    private String goalDesc;
    private Integer assignedTo;
    private Integer createdBy;
    private Date goalStartDate;
    private Date goalEndDate;
    private Date goalCreatedDate;
    private Date goalUpdatedDate;
    private String goalType;
    private String goalStatus;
    private Integer goalPriority;
    private String goalRef;
}
