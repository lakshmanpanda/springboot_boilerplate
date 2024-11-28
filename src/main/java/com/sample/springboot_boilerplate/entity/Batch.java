package com.sample.springboot_boilerplate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "batch")
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batch_id", nullable = false, updatable = false)
    private Integer batchId;

    @Column(name = "batch_name", nullable = false, length = 255)
    private String batchName;

    @Column(name = "batch_desc", nullable = false, length = 1500)
    private String batchDesc;

    @Column(name = "batch_status", nullable = false, length = 255)
    private String batchStatus;
}
