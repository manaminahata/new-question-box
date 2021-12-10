package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String userLogin() {
		return "user-login";
	}
}
