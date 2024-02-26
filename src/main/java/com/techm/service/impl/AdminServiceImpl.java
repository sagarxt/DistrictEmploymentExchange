package com.techm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.entity.Admin;
import com.techm.repository.AdminRepository;
import com.techm.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin login(String email, String password) {
		return adminRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public Admin register(Admin admin) {
		return adminRepository.save(admin);
	}
}
