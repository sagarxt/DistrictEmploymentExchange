package com.techm.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "job")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long jobId;
	
	private String jobTitle;
	
	private String jobDescription;
	
	private String jobLocation;
	
	private String jobType;
	
	private int numberOfRequirments;
	
	private boolean isActive;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employeerId", referencedColumnName = "employeerId")
	private Employeer employeer;
	
	public Job() {
	}

	public Job(String jobTitle, String jobDescription, String jobLocation, String jobType, int numberOfRequirments) {
		super();
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.jobLocation = jobLocation;
		this.jobType = jobType;
		this.numberOfRequirments = numberOfRequirments;
		this.isActive = true;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public int getNumberOfRequirments() {
		return numberOfRequirments;
	}

	public void setNumberOfRequirments(int numberOfRequirments) {
		this.numberOfRequirments = numberOfRequirments;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
