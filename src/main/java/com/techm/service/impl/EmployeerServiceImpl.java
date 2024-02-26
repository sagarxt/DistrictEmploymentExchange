package com.techm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.entity.Employeer;
import com.techm.repository.EmployeerRepository;
import com.techm.service.EmployeerService;

@Service
public class EmployeerServiceImpl implements EmployeerService {

	@Autowired
	private EmployeerRepository employeerRepository;

	@Override
	public Employeer register(Employeer employeer) {
		return employeerRepository.save(employeer);
	}

	@Override
	public Employeer login(String email, String password) {
		return employeerRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public Employeer update(Employeer employeer) {
		return employeerRepository.save(employeer);
	}
}
