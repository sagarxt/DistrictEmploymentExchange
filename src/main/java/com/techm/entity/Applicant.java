package com.techm.entity;

import java.util.List;

import com.techm.entity.enums.ApplicantStatus;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="applicant")
@AttributeOverrides({ @AttributeOverride(name = "userId", column = @Column(name = "userId")),
	@AttributeOverride(name = "name", column = @Column(name = "name")),
	@AttributeOverride(name = "email", column = @Column(name = "email")),
	@AttributeOverride(name = "password", column = @Column(name = "password")),
	@AttributeOverride(name = "role", column = @Column(name = "role")),
	@AttributeOverride(name = "isActive", column = @Column(name = "isActive")) })
@DiscriminatorValue("applicant")
public class Applicant extends User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long applicantId;
	
	@Column(nullable = false)
	private String phone;
	
	@Column(nullable = false)
	private ApplicantStatus applicantStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
	private Address address;
	
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
