package com.techm.entity;

import java.util.ArrayList;
import java.util.List;

import com.techm.entity.enums.ApplicantStatus;
import com.techm.entity.enums.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="applicant")
public class Applicant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long applicantId;
	
	private String name;
	
	private String email;
	
	private String phone;
	
	private String password;
	
	private String about;
	
	private ApplicantStatus applicantStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId", referencedColumnName = "addressId")
	private Address address;
	
	private Role role;
	
	private boolean isActive;
	
    @OneToMany(cascade = CascadeType.ALL)
	private List<Qualification> qualifications;
	
	public Applicant() {
	}

	public Applicant(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = Role.APPLICANT;
		this.isActive = true;
		this.qualifications = new ArrayList<>();
	}

	public Applicant(String phone, String about, ApplicantStatus applicantStatus, Address address,
			List<Qualification> qualifications) {
		super();
		this.phone = phone;
		this.about = about;
		this.applicantStatus = applicantStatus;
		this.address = address;
		this.qualifications = qualifications;
	}

	public Long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Long applicantId) {
		this.applicantId = applicantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<Qualification> qualifications) {
		this.qualifications = qualifications;
	}
	
}
