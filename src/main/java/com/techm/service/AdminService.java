package com.techm.service;

import org.springframework.stereotype.Service;

import com.techm.entity.Admin;

@Service
public interface AdminService {
	
	Admin login(String email, String password);
	
	Admin register(Admin admin);
}
