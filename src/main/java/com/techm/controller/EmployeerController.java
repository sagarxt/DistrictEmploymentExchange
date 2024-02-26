package com.techm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techm.service.EmployeerService;

@RestController
@RequestMapping("/employeer")
public class EmployeerController {

	@Autowired
	private EmployeerService employeerService;
}
