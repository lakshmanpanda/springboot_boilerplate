package com.sample.springboot_boilerplate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

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
    private LocalDate goalStartDate;
    private LocalDate goalEndDate;
    private LocalDate goalCreatedDate;
    private LocalDate goalUpdatedDate;
    private String goalType;
    private String goalStatus;
    private Integer goalPriority;
    private String goalRef;
}
