package com.techm.entity;

import com.techm.entity.enums.ApplicationStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Application {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long applicationId;
	
	@Column(nullable = false)
	private Applicant applicant;
	
	@Column(nullable = false)
	private Job job;
	
	@Column(nullable = false)
	private ApplicationStatus applicationStatus;
	
	public Application() {
	}

	public Application(Applicant applicant, Job job, ApplicationStatus applicationStatus) {
		super();
		this.applicant = applicant;
		this.job = job;
		this.applicationStatus = applicationStatus;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public ApplicationStatus getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(ApplicationStatus applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	
}
