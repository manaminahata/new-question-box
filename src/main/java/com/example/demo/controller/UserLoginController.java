package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.User;
import com.example.demo.form.UserLoginForm;
import com.example.demo.service.UserService;

/**
 * ユーザーのログイン・ログアウト処理を行うコントローラー
 * @author manami
 *
 */
@Controller
@RequestMapping("/questionbox")
public class UserLoginController {
	
	@Autowired
	private HttpSession session;
	
	@ModelAttribute
	private UserLoginForm setUpUserLoginForm() {
		return new UserLoginForm();
	}
	
	@Autowired
	private UserService userService;
	
	///////////////////////////////////
	//             ログイン            //
	///////////////////////////////////
	/**
	 * ユーザーログイン画面を表示する
	 * @return
	 */
	@RequestMapping("/user-login")
	public String userLogin() {
		return "user-login";
	}
	
	/**
	 * ユーザーログイン処理を実行する
	 * @return
	 */
	@RequestMapping("/user-signin")
	public String userSignIn(@Validated UserLoginForm form, BindingResult result, Model model) {
		
		/* 入力に不備があった場合、ログイン画面に戻る */
		if (result.hasErrors()) {
			return "user-login";
		}
		
		User user = userService.userLogin(form.getEmail(), form.getPassword());
		
		/* 一致するユーザーがいなかった場合はログイン画面に戻る */
		if (user == null) {
			model.addAttribute("comment", "一致するユーザーが見つかりません。");
			return "user-login";
		}
		
		BeanUtils.copyProperties(form, user);
		
		/* ログアウトするまでuserの値が使えるようにするためにsessionスコープに格納する */
		session.setAttribute("user", user);
		
		return "redirect:/questionbox/user-main";
	}
	
	///////////////////////////////////
	//            ログアウト           //
	///////////////////////////////////
	
	/**
	 * ログアウト後、インデックス画面に戻る
	 * @return
	 */
	@RequestMapping("/user-logout")
	public String logout() {
		session.invalidate();
		return "redirect:/questionbox/index";
	}
}
