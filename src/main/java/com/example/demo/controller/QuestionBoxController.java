package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/question")
public class QuestionBoxController {
	
	////////////////////////////////
	//　　　　　インデックス表示　　　　//
	////////////////////////////////
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	////////////////////////////////
	//　　　　　　　ユーザー　　　　　　//
	////////////////////////////////
	/**
	 * ユーザー登録画面を表示させるメソッド
	 * @return
	 */
	@RequestMapping("/user-register")
	public String userRegister() {
		return "user-confirm";
	}
	
	
	/**
	 * ユーザー登録情報を受け取る
	 * @return
	 */
	public String userSignUp() {
		return "redirect:user-login";
	}
	
	/**
	 * ユーザーログイン画面を表示する
	 * @return
	 */
	@RequestMapping("/user-login")
	public String userLogin() {
		return "user-login";
	}
}
