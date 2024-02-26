package com.techm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techm.entity.Applicant;

@Service
public interface ApplicantService {

	Applicant register(Applicant applicant);
	
	Optional<Applicant> login(String email, String password);
	
	Applicant update(Applicant applicant);
	
	List<Applicant> getAllApplicants();
	
	Optional<Applicant> getApplicantById(Long id);
	
	Applicant delete(Long id);
}
