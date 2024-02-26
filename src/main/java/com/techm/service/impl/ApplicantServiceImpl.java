package com.techm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.entity.Applicant;
import com.techm.entity.enums.Role;
import com.techm.repository.ApplicantRepository;
import com.techm.service.ApplicantService;

@Service
public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	private ApplicantRepository applicantRepository;

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
}
