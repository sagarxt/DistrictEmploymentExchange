package com.techm.entity;

import java.util.List;

import com.techm.entity.enums.ApplicantStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Applicant extends User {

	@Column(nullable = false)
	private String phone;
	
	@Column(nullable = false)
	private ApplicantStatus applicantStatus;
	
	@Column(nullable = false)
	private Address address;
	
	@Column(nullable = false)
	private List<Qualification> qualifications;
	
	@Column(nullable = false)
	private String about;
	
	public Applicant() {
	}

	public Applicant(String phone, ApplicantStatus applicantStatus, Address address, List<Qualification> qualifications,
			String about) {
		super();
		this.phone = phone;
		this.applicantStatus = applicantStatus;
		this.address = address;
		this.qualifications = qualifications;
		this.about = about;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ApplicantStatus getApplicantStatus() {
		return applicantStatus;
	}

	public void setApplicantStatus(ApplicantStatus applicantStatus) {
		this.applicantStatus = applicantStatus;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<Qualification> qualifications) {
		this.qualifications = qualifications;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
	
}
