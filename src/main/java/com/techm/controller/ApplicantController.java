package com.techm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techm.entity.Applicant;
import com.techm.service.ApplicantService;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
	
	@Autowired
	private ApplicantService applicantService;

	@PostMapping
	public ResponseEntity<Applicant> register(@RequestBody Applicant applicant) {
		Applicant savedApplicant = applicantService.saveApplicant(applicant);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedApplicant);
	}
}
