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
import com.techm.entity.Application;
import com.techm.entity.Job;
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
	
	@GetMapping("/{applicantId}")
	public ResponseEntity<Applicant> getApplicantById(@PathVariable Long applicantId){
		Applicant applicant = applicantService.getApplicantById(applicantId).orElse(null);
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
	
	@GetMapping("/alljobs")
	public ResponseEntity<List<Job>> getAllActiveJobs(){
		List<Job> jobs = applicantService.getAllActiveJobs();
		return ResponseEntity.status(HttpStatus.OK).body(jobs);
	}
	
	@PostMapping("/apply/{applicantId}/{jobId}")
	public ResponseEntity<Application> apply(@PathVariable Long applicantId, @PathVariable Long jobId){
		Application applied = applicantService.apply(applicantId, jobId);
		return ResponseEntity.status(HttpStatus.CREATED).body(applied);
		
	}
	
	@GetMapping("/applied/{applicantId}")
	public ResponseEntity<List<Job>> getAppliedJobs(@PathVariable Long applicantId){
		List<Job> jobs = applicantService.getAppliedJobs(applicantId);
		if(jobs == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(jobs);
	}
	
}
