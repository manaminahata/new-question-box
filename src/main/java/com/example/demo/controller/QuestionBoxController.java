package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * トップ画面表示
 * @author manami
 *
 */
@Controller
@RequestMapping("/questionbox")
public class QuestionBoxController {
	
	/**
	 * トップ画面表示
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	////////////////////////////////
	//　　　　　　　 管理者　　　　　  //
	////////////////////////////////
	
	/**
	 * 管理者登録画面を表示させるメソッド
	 * @return
	 */
	@RequestMapping("/administrator-register")
	public String administratorRegister() {
		return "administrator-register";
	}
	
	/**
	 * ユーザーログイン画面を表示する
	 * @return
	 */
	@RequestMapping("/administrator-login")
	public String administratorLogin() {
		return "administrator-login";
	}
	
}
