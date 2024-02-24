package com.techm.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Employeer extends User {
	
	@Column(nullable = false)
	private String companyName;
	
	@Column(nullable = false)
	private Address companyAddress;
	
	@Column(nullable = false)
	private String companyDescription;
	
	@Column(nullable = false)
	private List<Job> jobs;
	
	public Employeer() {
	}

	public Employeer(String companyName, Address companyAddress, String companyDescription) {
		super();
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.companyDescription = companyDescription;
		this.jobs = new ArrayList<>();
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Address getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(Address companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	
}
