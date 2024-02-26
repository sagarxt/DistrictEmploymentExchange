package com.techm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techm.entity.Employeer;
import com.techm.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

	List<Job> findJobsByEmployeer(Employeer employeer);

}
