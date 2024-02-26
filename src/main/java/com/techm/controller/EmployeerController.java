package com.techm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techm.entity.Employeer;
import com.techm.entity.Login;
import com.techm.service.EmployeerService;

@RestController
@RequestMapping("/employeer")
public class EmployeerController {

	@Autowired
	private EmployeerService employeerService;
	
	@PostMapping
	public ResponseEntity<Employeer> register(@RequestBody Employeer employeer){
		Employeer registeredEmployeer = employeerService.register(employeer);
		return ResponseEntity.status(HttpStatus.CREATED).body(registeredEmployeer);
	}
	
	@GetMapping
	public ResponseEntity<Employeer> login(@RequestBody Login login){
		Employeer employeer = employeerService.login(login.getEmail(), login.getPassword()).orElse(null);
		if(employeer == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(employeer);	
	}
	
	@PutMapping
	public ResponseEntity<Employeer> update(@RequestBody Employeer employeer){
		Employeer updatedEmployeer = employeerService.update(employeer);
		return ResponseEntity.status(HttpStatus.OK).body(updatedEmployeer);
	}
	
	
}
