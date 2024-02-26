package com.techm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techm.entity.Employeer;

@Repository
public interface EmployeerRepository  extends JpaRepository<Employeer, Long> {

	Employeer findByEmailAndPassword(String email, String password);

}
