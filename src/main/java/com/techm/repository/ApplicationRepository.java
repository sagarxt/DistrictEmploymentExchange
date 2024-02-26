package com.techm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techm.entity.Applicant;
import com.techm.entity.Application;
import com.techm.entity.Job;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

	List<Application> findByApplicant(Applicant applicant);

	List<Application> findByJob(Job job);

}
