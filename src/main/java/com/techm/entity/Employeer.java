package com.techm.entity;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "employeer")
public class Employeer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeerId;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String companyName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId", referencedColumnName = "addressId")
	private Address address;
	
	private String companyDescription;
	
    @OneToMany(cascade = CascadeType.ALL)
	private List<Job> jobs;
	
	private Role role;
	
	private boolean isActive;
	
	public Employeer() {
	}

	public Employeer(String name, String email, String password, String companyName, Address companyAddress,
			String companyDescription) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.companyName = companyName;
		this.address = companyAddress;
		this.companyDescription = companyDescription;
		this.role = Role.EMPLOYER;
		this.isActive = true;
		this.jobs = new ArrayList<>();
	}

	public Long getEmployeerId() {
		return employeerId;
	}

	public void setEmployeerId(Long employeerId) {
		this.employeerId = employeerId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Address getCompanyAddress() {
		return address;
	}

	public void setCompanyAddress(Address address) {
		this.address = address;
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

	
}
