package com.techm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techm.entity.Admin;
import com.techm.entity.Applicant;
import com.techm.entity.Employeer;
import com.techm.entity.Job;

@Service
public interface AdminService {
	
	Optional<Admin> login(String email, String password);
	
	Admin register(Admin admin);

	List<Applicant> getAllApplicants();

	List<Employeer> getAllEmployeers();

	List<Job> getAllJobs();

	Applicant deleteApplicant(Long applicantId);
	Applicant activeApplicant(Long applicantId);

	Employeer deleteEmployeer(Long employeerId);
	Employeer activeEmployeer(Long employeerId);

	Job deleteJob(Long jobId);

	Admin update(Admin admin);
}
