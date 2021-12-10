package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/question")
public class QuestionBoxController {
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	
	
	
	@RequestMapping("/login")
	public String userLogin() {
		return "user-login";
	}
}
