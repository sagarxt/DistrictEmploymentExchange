package com.techm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.techm.service.ApplicantService;

@RestController
public class ApplicantController {
	
	@Autowired
	private ApplicantService applicantService;

	
}
