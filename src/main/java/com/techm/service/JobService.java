package com.techm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techm.entity.Job;

@Service
public interface JobService {

	Job postJob(Job job);
	
	Job updateJob(Job job);
	
	Optional<Job> getJobById(Long jobId);
	
	Job deleteJob(Long jobId);
	
	List<Job> getAllJobs();
	
	List<Job> getJobsByEmployeerId(Long employeerId);
}
