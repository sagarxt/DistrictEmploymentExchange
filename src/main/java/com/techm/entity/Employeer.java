package com.techm.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employeer")
@AttributeOverrides({ @AttributeOverride(name = "userId", column = @Column(name = "userId")),
	@AttributeOverride(name = "name", column = @Column(name = "name")),
	@AttributeOverride(name = "email", column = @Column(name = "email")),
	@AttributeOverride(name = "password", column = @Column(name = "password")),
	@AttributeOverride(name = "role", column = @Column(name = "role")),
	@AttributeOverride(name = "isActive", column = @Column(name = "isActive")) })
@DiscriminatorValue("employeer")
public class Employeer extends User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeerId;
	
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
