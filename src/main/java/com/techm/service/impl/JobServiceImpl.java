package com.techm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.entity.Employeer;
import com.techm.entity.Job;
import com.techm.repository.JobRepository;
import com.techm.service.EmployeerService;
import com.techm.service.JobService;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private EmployeerService employeerService;
	
	@Override
	public Job postJob(Job job) {
		return jobRepository.save(job);
	}

	@Override
	public Job updateJob(Job job) {
		return jobRepository.save(job);
	}

	@Override
	public Optional<Job> getJobById(Long jobId) {
		return jobRepository.findById(jobId);
	}

	@Override
	public Job deleteJob(Long jobId) {
		Job job = jobRepository.findById(jobId).orElse(null);
		if (job != null) {
			job.setActive(false);
			return jobRepository.save(job);
		}
		return null;
	}

	@Override
	public List<Job> getAllJobs() {
		return jobRepository.findAll();
	}

	@Override
	public List<Job> getJobsByEmployeerId(Long employeerId) {
		Employeer employeer = employeerService.findById(employeerId).orElse(null);
		if (employeer != null) {
			return jobRepository.findJobsByEmployeer(employeer);
		}
		return null;
	}

}
