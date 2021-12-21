package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Answer;
import com.example.demo.domain.Question;
import com.example.demo.form.AnswerForm;
import com.example.demo.form.QuestionForm;
import com.example.demo.form.UserForm;
import com.example.demo.form.UserLoginForm;
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
	
	@Autowired
	private HttpSession session;
	
	@ModelAttribute
	private UserForm setUpUserForm() {
		return new UserForm();
	}
	
	@ModelAttribute
	private UserLoginForm setUpUserLoginForm() {
		return new UserLoginForm();
	}
	
	@ModelAttribute
	private AnswerForm setUpAnswerForm() {
		return new AnswerForm();
	}
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private QuestionService questionService;
	
	
	////////////////////////////////
	//　　　　　　　質問機能　　　　　　//
	////////////////////////////////
	
	/**
	 * 質問一覧画面の表示
	 * 投稿された質問を最新の投稿順に表示する
	 * @return
	 */
	@RequestMapping("/user-main")
	public String mainView(Model model) {
		List<Question> questionList = userService.showQuestionList();
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
	 * 質問詳細と回答を表示する
	 * @return
	 */
	@RequestMapping("/user-questionDetail")
	public String questionDetail(int id, Model model) {
		Question question = questionService.findByQuestionAndAnswer(id);
//		BeanUtils.copyProperties(questionForm, question);
		System.out.println("asdfghjkl;");
		System.out.println(question);
		session.setAttribute("question", question);
		return "question-detail";
	}
	
	/**
	 * 質問投稿
	 * 「投稿」を押すとメインの画面に戻り、最新の投稿が一番上に表示される
	 * @return
	 */
	@RequestMapping("/post-question")
	public String postQuestion(QuestionForm questionForm, Model model) {
		Question question = new Question();
		BeanUtils.copyProperties(questionForm, question);
		question.setUserId(questionForm.getUserId());
		userService.postQuestion(question);
		model.addAttribute("question", question);
		return "redirect:/questionbox/user-main";
	}
	
	////////////////////////////////
	//　　　　　 質問回答機能　　　　　//
	////////////////////////////////
	
	/**
	 * 質問に対して回答する
	 * @return
	 */
	@RequestMapping("/post-answer")
	public String postAnswer(AnswerForm answerForm, Model model) {
		Answer answer = new Answer();
		BeanUtils.copyProperties(answerForm, answer);
		userService.postAnswer(answer);
		model.addAttribute("answer", answer);
		return "redirect:/questionbox/user-questionDetail?id=" + answerForm.getQuestionId();
	}
	
}
