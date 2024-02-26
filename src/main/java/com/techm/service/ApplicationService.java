package com.techm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techm.entity.Application;
import com.techm.entity.Job;

@Service
public interface ApplicationService {

	List<Application> findAll();
	
	Optional<Application> findById(Long applicationId);
	
	List<Application> findByApplicantId(Long applicantId);
	
	List<Application> findByJobId(Long jobId);
	
	List<Application> findByEmployeerId(Long employeerId);
	
	List<Application> findByJob(Job job);
}
