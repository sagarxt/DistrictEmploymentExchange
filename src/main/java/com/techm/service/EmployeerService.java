package com.techm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techm.entity.Employeer;

@Service
public interface EmployeerService {
	
	Employeer register(Employeer employeer);

	Optional<Employeer> login(String email, String password);
	
	Employeer update(Employeer employeer);
	
	Employeer delete(Long id);
	
	Optional<Employeer> findById(Long id);
	
	List<Employeer> findAll();
	
}
