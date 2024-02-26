package com.techm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.entity.Admin;
import com.techm.entity.Applicant;
import com.techm.entity.Employeer;
import com.techm.entity.Job;
import com.techm.repository.AdminRepository;
import com.techm.service.AdminService;
import com.techm.service.ApplicantService;
import com.techm.service.EmployeerService;
import com.techm.service.JobService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private ApplicantService applicantService;
	
	@Autowired
	private EmployeerService employeerService;
	
	@Autowired
	private JobService jobService;

	@Override
	public Optional<Admin> login(String email, String password) {
		return Optional.ofNullable(adminRepository.findByEmailAndPassword(email, password));
	}

	@Override
	public Admin register(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public List<Applicant> getAllApplicants() {
		return applicantService.getAllApplicants();
	}

	@Override
	public List<Employeer> getAllEmployeers() {
		return employeerService.findAll();
	}

	@Override
	public List<Job> getAllJobs() {
		return jobService.getAllJobs();
	}

	@Override
	public Applicant deleteApplicant(Long applicantId) {
		Applicant applicant = applicantService.getApplicantById(applicantId).orElse(null);
		if (applicant != null) {
			applicant.setActive(false);
			return applicantService.update(applicant);
		}
		return null;
	}

	@Override
	public Employeer deleteEmployeer(Long employeerId) {
		Employeer employeer = employeerService.findById(employeerId).orElse(null);
		if (employeer != null) {
			employeer.setActive(false);
			return employeerService.update(employeer);
		}
		return null;
	}
	
	
	@Override
	public Applicant activeApplicant(Long applicantId) {
		Applicant applicant = applicantService.getApplicantById(applicantId).orElse(null);
		if (applicant != null) {
			applicant.setActive(true);
			return applicantService.update(applicant);
		}
		return null;
	}

	@Override
	public Employeer activeEmployeer(Long employeerId) {
		Employeer employeer = employeerService.findById(employeerId).orElse(null);
		if (employeer != null) {
			employeer.setActive(true);
			return employeerService.update(employeer);
		}
		return null;
	}

	@Override
	public Job deleteJob(Long jobId) {
		Job job = jobService.getJobById(jobId).orElse(null);
		if (job != null) {
			job.setActive(false);
			return jobService.updateJob(job);
		}
		return null;
	}

	@Override
	public Admin update(Admin admin) {
		return adminRepository.save(admin);
	}
}
