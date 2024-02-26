package com.techm.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techm.entity.Admin;

@Service
public interface AdminService {
	
	Optional<Admin> login(String email, String password);
	
	Admin register(Admin admin);
}
