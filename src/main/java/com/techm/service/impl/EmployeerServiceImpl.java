package com.techm.service.impl;

import java.util.List;
import java.util.Optional;

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
	public Optional<Employeer> login(String email, String password) {
		return Optional.ofNullable(employeerRepository.findByEmailAndPassword(email, password));
	}

	@Override
	public Employeer update(Employeer employeer) {
		return employeerRepository.save(employeer);
	}

	@Override
	public Employeer delete(Long employeerId) {
		Employeer employeer = employeerRepository.findById(employeerId).orElse(null);
		if (employeer != null) {
			employeer.setActive(false);
			return employeerRepository.save(employeer);
		}
		return null;
	}

	@Override
	public Optional<Employeer> findById(Long employeerId) {
		return employeerRepository.findById(employeerId);
		
	}

	@Override
	public List<Employeer> findAll() {
		return employeerRepository.findAll();
	}
}
