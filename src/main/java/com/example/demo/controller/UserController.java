package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.domain.Question;
import com.example.demo.domain.User;
import com.example.demo.form.QuestionForm;
import com.example.demo.form.UserForm;
import com.example.demo.service.QuestionService;
import com.example.demo.service.UserService;

/**
 * ユーザー情報の登録・ログイン用
 * @author manami
 *
 */
@Controller
@RequestMapping("/questionbox")
public class UserController {
	
	@ModelAttribute
	private UserForm setUpUserForm() {
		return new UserForm();
	}
	
	@Autowired
	private UserService userService;
	
	////////////////////////////////
	//　　　　　　ユーザー登録　　　　　//
	////////////////////////////////
	
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
	@RequestMapping(value = "/user-confirm", method = RequestMethod.POST)
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
	
	////////////////////////////////
	//　　　　　　　ログイン　　　　　　//
	////////////////////////////////
	
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
	public String userSignIn(@Validated UserForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "user-login";
		}
		System.out.println(form.getEmail());
		System.out.println(form.getPassword());
		User user = userService.userLogin(form.getEmail(), form.getPassword());
		BeanUtils.copyProperties(form, user);
		model.addAttribute("user", user);
		return "questionbox";
	}
	
	////////////////////////////////
	//　　　　　　　質問機能　　　　　　//
	////////////////////////////////
	
	/**
	 * 質問投稿一覧画面の表示
	 * @return
	 */
	@RequestMapping("/user-main")
	public String mainView(Model model) {
		List<Question> questionList = userService.showQuestions();
		model.addAttribute("questionList", questionList);
		return "questionbox";
	}
	
	/**
	 * 質問投稿画面の表示
	 * @return
	 */
	@RequestMapping("/question-form")
	public String thorwQuestion(QuestionForm questionForm, Model model) {
		
		return "question-form";
	}
	
	/**
	 * 質問投稿
	 * @return
	 */
	@RequestMapping("/post-question")
	public String postQuestion(QuestionForm questionForm, Model model) {
		Question question = new Question();
		BeanUtils.copyProperties(questionForm, question);
		userService.postQuestion(question);
		model.addAttribute("question", question);
		return "redirect:questionbox";
	}
	
	
}
