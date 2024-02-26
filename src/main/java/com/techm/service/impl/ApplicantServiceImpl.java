package com.techm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.entity.Applicant;
import com.techm.entity.Application;
import com.techm.entity.Job;
import com.techm.entity.enums.ApplicationStatus;
import com.techm.entity.enums.Role;
import com.techm.repository.AddressRepository;
import com.techm.repository.ApplicantRepository;
import com.techm.repository.ApplicationRepository;
import com.techm.repository.JobRepository;
import com.techm.service.ApplicantService;

@Service
public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	private ApplicantRepository applicantRepository;

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Override
	public Applicant register(Applicant applicant) {
		applicant.setRole(Role.APPLICANT);
		applicant.setActive(true);
		return applicantRepository.save(applicant);
	}

	@Override
	public Optional<Applicant> login(String email, String password) {
		return Optional.ofNullable(applicantRepository.findByEmailAndPassword(email, password));
	}

	@Override
	public Applicant update(Applicant applicant) {
		return applicantRepository.save(applicant);
	}

	@Override
	public List<Applicant> getAllApplicants() {
		return applicantRepository.findAll();
	}

	@Override
	public Optional<Applicant> getApplicantById(Long id) {
		return applicantRepository.findById(id);
	}

	@Override
	public Applicant delete(Long id) {
		Optional<Applicant> applicant = getApplicantById(id);
		if (applicant.isPresent()) {
			Applicant applicant1 = applicant.get();
			applicant1.setActive(false);
			return applicantRepository.save(applicant1);
		} else {
			return null;
		}
	}

	@Override
	public List<Job> getAllActiveJobs() {
		return jobRepository.findByIsActive(true);			
	}

	@Override
	public Application apply(Long applicatId, Long jobId) {
		// TODO Auto-generated method stub
		Applicant applicant = applicantRepository.findById(applicatId).orElse(null);
		Job job = jobRepository.findById(jobId).orElse(null);
		if(applicant != null && job != null) {
			Application application = new Application(applicant,job);
			application.setApplicationStatus(ApplicationStatus.PENDING);
			return applicationRepository.save(application);
		}else {
			return null;
		}
	}

	@Override
	public List<Job> getAppliedJobs(Long applicantId) {
		Applicant applicant = applicantRepository.findById(applicantId).orElse(null);
		if(applicant != null) {
			List<Application> applications =applicationRepository.findByApplicant(applicant);
			List<Job> jobs = new ArrayList<Job>();
			for(Application application : applications) {
				
					jobs.add(application.getJob());
			}
			return jobs;
		}
		return null;
	}

	
}
