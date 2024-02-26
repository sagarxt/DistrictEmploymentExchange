package com.techm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techm.entity.Applicant;
import com.techm.entity.Application;
import com.techm.entity.Employeer;
import com.techm.entity.Job;

@Service
public interface EmployeerService {
	
	Employeer register(Employeer employeer);

	Optional<Employeer> login(String email, String password);
	
	Employeer update(Employeer employeer);
	
	Employeer delete(Long id);
	
	Optional<Employeer> findById(Long employeerId);
	
	List<Employeer> findAll();

	Job postJob(Job job);

	Job updateJob(Job job);

	Optional<Job> getJobById(Long jobId);

	List<Job> findJobByEmployeer(Long employeerId);

	Job deleteJob(Job job);

	List<Applicant> getAppliedApplicants(Long jobId);

	Optional<Applicant> getApplicantById(Long applicantId);

	Application updateApplicationStatus(Long applicationId, String status);
	
}
