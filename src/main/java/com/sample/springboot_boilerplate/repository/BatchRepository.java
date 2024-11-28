package com.sample.springboot_boilerplate.repository;

import com.sample.springboot_boilerplate.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer> {

}
