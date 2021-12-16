package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Question;
import com.example.demo.form.QuestionForm;
import com.example.demo.form.UserForm;
import com.example.demo.service.QuestionService;

/**
 * トップ画面表示
 * @author manami
 *
 */
@Controller
@RequestMapping("/questionbox")
public class QuestionBoxController {
	
	@Autowired
	private QuestionService questionService;
	
	@ModelAttribute
	public QuestionForm questionSetUpForm() {
		return new QuestionForm();
	}
	
	@ModelAttribute
	public UserForm userSetUpForm() {
		return new UserForm();
	}
	
	////////////////////////////////
	//　　　　　　トップ画面表示　　　　//
	////////////////////////////////
	
	/**
	 * トップ画面表示
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	////////////////////////////////
	//　　　　　　　質問投稿　　　　　  //
	////////////////////////////////
	
//	/**
//	 * 質問を投稿する
//	 * @return
//	 */
//	@RequestMapping("/post-question")
//	public String postQuestion(QuestionForm questionForm, UserForm userForm, Model model) {
//		Question question = questionService.postQuestion(questionForm.getTitle(), questionForm.getQuestion(), userForm.getId());
//		
//		
//		return "redirect:questionbox";
//	}
}
