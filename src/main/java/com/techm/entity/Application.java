package com.techm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techm.entity.enums.ApplicationStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


@Entity
public class Application {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long applicationId;
	
	//@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "applicantId", referencedColumnName = "applicantId",unique = false)
	private Applicant applicant;
	
	//@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "jobId", referencedColumnName = "jobId",unique = false)
	private Job job;
	
	@Enumerated(EnumType.STRING)
	private ApplicationStatus applicationStatus;
	
	public Application() {
	}

	public Application(Applicant applicant, Job job) {
		super();
		this.applicant = applicant;
		this.job = job;
		this.applicationStatus = ApplicationStatus.PENDING;
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
