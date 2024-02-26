package com.techm.entity;

import com.techm.entity.enums.QualificationType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "qualification")
public class Qualification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long qualificationId;
	
	private QualificationType qualificationType;
	
	private String collegeName;
	
	private String universityName;
	
	private String description;
	
	private int yearOfJoining;
	
	private int yearOfPassing;
	
	private double percentage;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "applicantId", referencedColumnName = "applicantId")
	private Applicant applicant;
	
	public Qualification() {
	}

	public Qualification(QualificationType qualificationType, String collegeName, String universityName,
			String description, int yearOfJoining, int yearOfPassing, double percentage) {
		super();
		this.qualificationType = qualificationType;
		this.collegeName = collegeName;
		this.universityName = universityName;
		this.description = description;
		this.yearOfJoining = yearOfJoining;
		this.yearOfPassing = yearOfPassing;
		this.percentage = percentage;
	}

	public Long getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(Long qualificationId) {
		this.qualificationId = qualificationId;
	}

	public QualificationType getQualificationType() {
		return qualificationType;
	}

	public void setQualificationType(QualificationType qualificationType) {
		this.qualificationType = qualificationType;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}

	public int getYearOfPassing() {
		return yearOfPassing;
	}

	public void setYearOfPassing(int yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

}
