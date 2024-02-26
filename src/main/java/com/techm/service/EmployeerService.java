package com.techm.service;

import org.springframework.stereotype.Service;

import com.techm.entity.Employeer;

@Service
public interface EmployeerService {
	
	Employeer register(Employeer employeer);

	Employeer login(String email, String password);
	
	Employeer update(Employeer employeer);
	
}
