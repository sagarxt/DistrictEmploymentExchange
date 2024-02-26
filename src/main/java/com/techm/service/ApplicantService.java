package com.techm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techm.entity.Applicant;
import com.techm.entity.Application;
import com.techm.entity.Job;

@Service
public interface ApplicantService {

	Applicant register(Applicant applicant);
	
	Optional<Applicant> login(String email, String password);
	
	Applicant update(Applicant applicant);
	
	List<Applicant> getAllApplicants();
	
	Optional<Applicant> getApplicantById(Long id);
	
	Applicant delete(Long id);

	List<Job> getAllActiveJobs();

	Application apply(Long applicatId,Long jobId);

	List<Job> getAppliedJobs(Long applicantId);
}
