package com.example.demo.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.User;
import com.example.demo.form.UserForm;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/questionbox")
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
	
	@ModelAttribute
	private UserForm setUpUserForm() {
		return new UserForm();
	}
	
	@Autowired
	private UserService userService;
	
	/**
	 * ユーザー情報入力画面を表示させるメソッド
	 * @return
	 */
	@RequestMapping("/user-register")
	public String userRegister() {
		return "user-register";
	}
	
	/**
	 * 入力されたユーザー情報を受け取り、内容を表示する
	 * 登録内容を修正する場合は「修正ボタン」を押すと「userSignUpメソッド」に遷移する
	 * 登録内容に誤りがない場合は「登録ボタン」を押すとログイン画面に遷移する
	 * @return
	 */
	@RequestMapping("/user-confirm")
	public String userSignUp(@Validated UserForm userForm, BindingResult result, Model model) {
		
		/* 登録情報に不備がある場合、登録画面に戻る */
		if (result.hasErrors()) {
			return "user-register";
		}
		
		/* 登録内容が正常の場合、登録内容確認画面に遷移する */
		User user = new User();
		BeanUtils.copyProperties(userForm, user);
		userService.signUp(user);
		model.addAttribute(user);
		
		System.out.println(user);
		
		return "user-confirm";
	}
	
	/**
	 * 登録完了の表示とログインへの誘導を行う
	 * @return
	 */
	@RequestMapping("/user-result")
	public String userConfirm() {
		return "user-result";
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
	
	/**
	 * ユーザーログイン画面を表示する
	 * @return
	 */
	@RequestMapping("/administrator-login")
	public String administratorLogin() {
		return "administrator-login";
	}
	
}
