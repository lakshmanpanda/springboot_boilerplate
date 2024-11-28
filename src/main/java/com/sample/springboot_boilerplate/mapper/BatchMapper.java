package com.sample.springboot_boilerplate.mapper;

import com.sample.springboot_boilerplate.dto.BatchDTO;
import com.sample.springboot_boilerplate.entity.Batch;
import org.springframework.stereotype.Component;

@Component
public class BatchMapper {

    public BatchDTO mapToDto(Batch batch) {
        return new BatchDTO(
                batch.getBatchId(),
                batch.getBatchName(),
                batch.getBatchDesc(),
                batch.getBatchStatus()
        );
    }

    public Batch mapToEntity(BatchDTO batchDTO) {
        Batch batch = new Batch();
        batch.setBatchName(batchDTO.getBatchName());
        batch.setBatchDesc(batchDTO.getBatchDesc());
        batch.setBatchStatus(batchDTO.getBatchStatus());
        return batch;
    }
}
