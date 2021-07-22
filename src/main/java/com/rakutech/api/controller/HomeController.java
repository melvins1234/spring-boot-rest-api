package com.rakutech.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  
public class HomeController {

	@RequestMapping("/")
	public String homView() {
		return "Hello World";
	}
}
