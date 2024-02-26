package com.techm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techm.entity.Applicant;
import com.techm.entity.Login;
import com.techm.service.ApplicantService;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
	
	@Autowired
	private ApplicantService applicantService;
	
	@PostMapping
	public ResponseEntity<Applicant> register(@RequestBody Applicant applicant){
		Applicant registeredApplicant = applicantService.register(applicant);
		return ResponseEntity.status(HttpStatus.CREATED).body(registeredApplicant);
	}
	
	@GetMapping
	public ResponseEntity<Applicant> login(@RequestBody Login login){
		Applicant applicant = applicantService.login(login.getEmail(), login.getPassword()).orElse(null);
		if(applicant == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(applicant);
	}

	@PutMapping
	public ResponseEntity<Applicant> update(@RequestBody Applicant applicant){
		Applicant updatedApplicant = applicantService.update(applicant);
		return ResponseEntity.status(HttpStatus.OK).body(updatedApplicant);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Applicant>> getAllApplicants(){
		List<Applicant> applicants = applicantService.getAllApplicants();
		return ResponseEntity.status(HttpStatus.OK).body(applicants);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Applicant> getApplicantById(@PathVariable Long id){
		Applicant applicant = applicantService.getApplicantById(id).orElse(null);
		if(applicant == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(applicant);
	}
	
	@PutMapping("/delete/{id}")
	public ResponseEntity<Applicant> delete(@PathVariable Long id){
		Applicant deletedApplicant = applicantService.delete(id);
		if(deletedApplicant == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(deletedApplicant);
	}
	
}
