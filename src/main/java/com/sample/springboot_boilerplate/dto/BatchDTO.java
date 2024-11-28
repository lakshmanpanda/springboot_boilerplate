package com.sample.springboot_boilerplate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchDTO {
    private Integer batchId;
    private String batchName;
    private String batchDesc;
    private String batchStatus;
}
