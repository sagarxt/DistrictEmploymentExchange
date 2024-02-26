package com.techm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.entity.Applicant;
import com.techm.entity.Application;
import com.techm.entity.Job;
import com.techm.repository.ApplicationRepository;
import com.techm.service.ApplicantService;
import com.techm.service.ApplicationService;
import com.techm.service.JobService;

@Service
public class ApplicationServiceImpl implements ApplicationService {
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Autowired
	private ApplicantService applicantService;
	
	@Autowired
	private JobService jobService;

	@Override
	public List<Application> findAll() {
		return applicationRepository.findAll();
	}

	@Override
	public Optional<Application> findById(Long applicationId) {
		return applicationRepository.findById(applicationId);
	}

	@Override
	public List<Application> findByApplicantId(Long applicantId) {
		Applicant applicant = applicantService.getApplicantById(applicantId).get();
		if(applicant != null) {
			return applicationRepository.findByApplicant(applicant);
		}
		return null;
	}

	@Override
	public List<Application> findByJobId(Long jobId) {
		Job job = jobService.getJobById(jobId).get();
		if(job != null) {
			return applicationRepository.findByJob(job);
		}
		return null;
	}

	@SuppressWarnings("null")
	@Override
	public List<Application> findByEmployeerId(Long employeerId) {
		List<Job> jobs = jobService.getJobsByEmployeerId(employeerId);
		List<Application> applications = null;
		if(jobs != null) {
			for(Job job : jobs) {
				applications.addAll(applicationRepository.findByJob(job));
			}
		}
		return applications;
	}

	@Override
	public List<Application> findByJob(Job job) {
		return applicationRepository.findByJob(job);
	}

}
