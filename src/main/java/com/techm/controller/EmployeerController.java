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
import com.techm.entity.Employeer;
import com.techm.entity.Job;
import com.techm.entity.Login;
import com.techm.service.EmployeerService;

@RestController
@RequestMapping("/employeer")
public class EmployeerController {

	@Autowired
	private EmployeerService employeerService;

	@PostMapping
	public ResponseEntity<Employeer> register(@RequestBody Employeer employeer) {
		Employeer registeredEmployeer = employeerService.register(employeer);
		return ResponseEntity.status(HttpStatus.CREATED).body(registeredEmployeer);
	}

	@GetMapping
	public ResponseEntity<Employeer> login(@RequestBody Login login) {
		Employeer employeer = employeerService.login(login.getEmail(), login.getPassword()).orElse(null);
		if (employeer == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(employeer);
	}

	@GetMapping("/{employeerId}")
	public ResponseEntity<Employeer> getEmployeerById(@PathVariable Long employeerId) {
		Employeer employeer = employeerService.findById(employeerId).orElse(null);
		if (employeer == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(employeer);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employeer>> getAllEmployeers(){
		return ResponseEntity.status(HttpStatus.OK).body(employeerService.findAll());
	}
	
	@PutMapping
	public ResponseEntity<Employeer> update(@RequestBody Employeer employeer) {
		Employeer updatedEmployeer = employeerService.update(employeer);
		return ResponseEntity.status(HttpStatus.OK).body(updatedEmployeer);
	}

	@PostMapping("/jobs/{employeerId}")
	public ResponseEntity<Job> postJob(@RequestBody Job job, @PathVariable Long employeerId){
		Employeer employeer = employeerService.findById(employeerId).orElse(null);
		if(employeer != null) {
			job.setEmployeer(employeer);
			Job postedJob = employeerService.postJob(job);
			return ResponseEntity.status(HttpStatus.CREATED).body(postedJob);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@GetMapping("/jobs/{employeerId}")
	public ResponseEntity<List<Job>> getAllJobsByEmployeer(@PathVariable Long employeerId){
		List<Job> jobs = employeerService.findJobByEmployeer(employeerId);
		if(jobs != null) {
			return ResponseEntity.status(HttpStatus.OK).body(jobs);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@PutMapping("/jobs")
	public ResponseEntity<Job> updateJob(@RequestBody Job job){
		Job updatedJob = employeerService.updateJob(job);
		return ResponseEntity.status(HttpStatus.OK).body(updatedJob);
	}
	
	@GetMapping("/job/{jobId}")
	public ResponseEntity<Job> getJobById(@PathVariable Long jobId){
		Job job = employeerService.getJobById(jobId).orElse(null);
		if(job == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(job);
	}
	
	@PutMapping("/job/{jobId}")
	public ResponseEntity<Job> deleteJob(@PathVariable Long jobId){
		Job job = employeerService.getJobById(jobId).orElse(null);
		if(job != null) {
			Job deletedJob = employeerService.deleteJob(job);
			return ResponseEntity.status(HttpStatus.OK).body(deletedJob);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@GetMapping("/applied_applicant/{jobId}")
	public ResponseEntity<List<Applicant>> getAppliedApplicants(@PathVariable Long jobId){
		List<Applicant> applicants = employeerService.getAppliedApplicants(jobId);
		if(applicants != null) {
			return ResponseEntity.status(HttpStatus.OK).body(applicants);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
	}
	
	@GetMapping("/applicant/{applicantId}")
	public ResponseEntity<Applicant> getApplicantById(@PathVariable Long applicantId){
		Applicant applicant = employeerService.getApplicantById(applicantId).orElse(null);
		if(applicant == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(applicant);
	}
	
	@PutMapping("/update_application_status/{applicationId}/{status}")
	public ResponseEntity<Application> updateApplicationStatus(@PathVariable Long applicationId, @PathVariable String status){
		Application application = employeerService.updateApplicationStatus(applicationId, status);
		return ResponseEntity.status(HttpStatus.OK).body(application);
	}
	
}
