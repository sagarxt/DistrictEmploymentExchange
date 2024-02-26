package com.techm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.entity.Applicant;
import com.techm.repository.ApplicantRepository;

@Service
public class ApplicantService {

	@Autowired
	private ApplicantRepository applicantRepository;
	
	public Applicant saveApplicant(Applicant applicant) {
		return applicantRepository.save(applicant);
	}
}
