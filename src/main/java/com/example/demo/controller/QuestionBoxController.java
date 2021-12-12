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
	 * ユーザー登録情報を受け取り、登録内容確認画面に遷移する
	 * @return
	 */
	@RequestMapping("/user-signup")
	public String userSignUp() {
		return "redirect:user-login";
	}
	
	/**
	 * 登録した内容を表示する
	 * 登録内容を修正する場合は「修正ボタン」を押すと「userSignUpメソッド」に遷移する
	 * 登録内容に誤りがない場合は「登録ボタン」を押すとログイン画面に遷移する
	 * @return
	 */
	@RequestMapping("/")
	public String userConfirm() {
		return "user-confirm";
	}
	
	/**
	 * ユーザーログイン画面を表示する
	 * @return
	 */
	@RequestMapping("/user-login")
	public String userLogin() {
		return "user-login";
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
	
	
}
