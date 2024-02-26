package com.techm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.entity.Applicant;
import com.techm.entity.Application;
import com.techm.entity.Employeer;
import com.techm.entity.Job;
import com.techm.entity.enums.ApplicationStatus;
import com.techm.entity.enums.Role;
import com.techm.repository.ApplicantRepository;
import com.techm.repository.ApplicationRepository;
import com.techm.repository.EmployeerRepository;
import com.techm.repository.JobRepository;
import com.techm.service.EmployeerService;

@Service
public class EmployeerServiceImpl implements EmployeerService {

	@Autowired
	private EmployeerRepository employeerRepository;
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Autowired
	private ApplicantRepository applicantRepository;

	@Override
	public Employeer register(Employeer employeer) {
		employeer.setActive(true);
		employeer.setRole(Role.EMPLOYER);
		return employeerRepository.save(employeer);
	}

	@Override
	public Optional<Employeer> login(String email, String password) {
		return Optional.ofNullable(employeerRepository.findByEmailAndPassword(email, password));
	}

	@Override
	public Employeer update(Employeer employeer) {
		employeer.setRole(Role.EMPLOYER);
		return employeerRepository.save(employeer);
	}

	@Override
	public Employeer delete(Long employeerId) {
		Employeer employeer = employeerRepository.findById(employeerId).orElse(null);
		if (employeer != null) {
			employeer.setActive(false);
			return employeerRepository.save(employeer);
		}
		return null;
	}

	@Override
	public Optional<Employeer> findById(Long employeerId) {
		return employeerRepository.findById(employeerId);	
	}

	@Override
	public List<Employeer> findAll() {
		return employeerRepository.findAll();
	}

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
	public List<Job> findJobByEmployeer(Long employeerId) {
		Employeer employeer = employeerRepository.findById(employeerId).orElse(null);
		if(employeer != null) {
			List<Job> jobs = jobRepository.findByEmployeer(employeer);
			return jobs;
		}
		return null;
	}

	@Override
	public Job deleteJob(Job job) {
		job.setActive(false);
		return jobRepository.save(job);
		
	}

	@Override
	public List<Applicant> getAppliedApplicants(Long jobId) {
		Job job = jobRepository.findById(jobId).orElse(null);
		List<Applicant> applicants = new ArrayList<Applicant>();
		if(job != null) {
			List<Application> applications = applicationRepository.findByJob(job);
			for(Application application : applications) {
				applicants.add(application.getApplicant());
			}
			return applicants;
		}
		return null;
	}

	@Override
	public Optional<Applicant> getApplicantById(Long applicantId) {
		return applicantRepository.findById(applicantId);
	}

	@Override
	public Application updateApplicationStatus(Long applicationId, String status) {
		
		Application application = applicationRepository.findById(applicationId).orElse(null);
		if(application != null) {
			if(status.equalsIgnoreCase("APPROVED") ) {
				application.setApplicationStatus(ApplicationStatus.APPROVED);
			}else if(status.equalsIgnoreCase("REJECTED")) {
				application.setApplicationStatus(ApplicationStatus.REJECTED);
			}
			
			return applicationRepository.save(application);
		}
		return null;
	}
}
