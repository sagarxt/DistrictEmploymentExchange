package com.techm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techm.entity.Admin;
import com.techm.entity.Login;
import com.techm.entity.enums.Role;
import com.techm.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping
	public ResponseEntity<Admin> register(@RequestBody Admin admin){
		admin.setRole(Role.ADMIN);
		Admin registeredAdmin = adminService.register(admin);
		return ResponseEntity.status(HttpStatus.CREATED).body(registeredAdmin);
	}
	
	@GetMapping
	public ResponseEntity<Admin> login(@RequestBody Login login){
		Admin admin = adminService.login(login.getEmail(), login.getPassword()).orElse(null);
		if(admin == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(admin);
		
	}
}
