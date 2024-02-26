package com.techm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techm.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

}
