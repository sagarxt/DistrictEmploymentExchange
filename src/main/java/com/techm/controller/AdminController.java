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

import com.techm.entity.Admin;
import com.techm.entity.Applicant;
import com.techm.entity.Employeer;
import com.techm.entity.Job;
import com.techm.entity.Login;
import com.techm.entity.enums.Role;
import com.techm.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	
	
	@PostMapping
	public ResponseEntity<Admin> register(@RequestBody Admin admin){
		admin.setRole(Role.ADMIN);
		Admin registeredAdmin = adminService.register(admin);
		return ResponseEntity.status(HttpStatus.CREATED).body(registeredAdmin);
	}
	
	@GetMapping
	public ResponseEntity<Admin> login(@RequestBody Login login){
		Admin admin = adminService.login(login.getEmail(), login.getPassword()).orElse(null);
		if(admin == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(admin);
		
	}
	
	@PutMapping
	public ResponseEntity<Admin> update(@RequestBody Admin admin){
		Admin updatedAdmin = adminService.update(admin);
		return ResponseEntity.status(HttpStatus.OK).body(updatedAdmin);
	}
	
	@GetMapping("/all_applicants")
	public ResponseEntity<List<Applicant>> getAllApplicants(){
		List<Applicant> applicants = adminService.getAllApplicants();
		if(applicants == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(applicants);
	}
	
	@GetMapping("/all_employeers")
	public ResponseEntity<List<Employeer>> getAllEmployeers(){
		List<Employeer> employeers = adminService.getAllEmployeers();
		if(employeers == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(employeers);
	}
	
	@GetMapping("/all_jobs")
	public ResponseEntity<List<Job>> getAllJobs(){
		List<Job> jobs = adminService.getAllJobs();
		if(jobs == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(jobs);
	}
	
	@PutMapping("/delete_applicant/{applicantId}")
	public ResponseEntity<Applicant> deleteApplicant(@PathVariable Long applicantId){
		Applicant deletedApplicant = adminService.deleteApplicant(applicantId);
		if(deletedApplicant == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(deletedApplicant);
	}
	
	@PutMapping("/delete_employeer/{employeerId}")
	public ResponseEntity<Employeer> deleteEmployeer(@PathVariable Long employeerId){
		Employeer deletedEmployeer = adminService.deleteEmployeer(employeerId);
		if(deletedEmployeer == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(deletedEmployeer);	
	}
	
	@PutMapping("/active_applicant/{applicantId}")
	public ResponseEntity<Applicant> activeApplicant(@PathVariable Long applicantId){
		Applicant deletedApplicant = adminService.activeApplicant(applicantId);
		if(deletedApplicant == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(deletedApplicant);
	}
	
	@PutMapping("/active_employeer/{employeerId}")
	public ResponseEntity<Employeer> activeEmployeer(@PathVariable Long employeerId){
		Employeer deletedEmployeer = adminService.activeEmployeer(employeerId);
		if(deletedEmployeer == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(deletedEmployeer);	
	}
	@PutMapping("/delete_job/{jobId}")
	public ResponseEntity<Job> deleteJob(@PathVariable Long jobId){
		Job deletedJob = adminService.deleteJob(jobId);
		if(deletedJob == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(deletedJob);
	}
}
