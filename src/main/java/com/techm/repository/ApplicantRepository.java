package com.techm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techm.entity.Applicant;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

}
