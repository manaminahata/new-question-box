package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Question;
import com.example.demo.domain.User;
import com.example.demo.form.UserForm;
import com.example.demo.repository.QuestionMapper;
import com.example.demo.repository.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private QuestionMapper questionMapper;
	
	/**
	 * ユーザー情報登録用
	 * @param user
	 */
	public void signUp(User user) {
		userMapper.insert(user);
		System.out.println(user);
	}
	
	/**
	 *「メールアドレス」と「パスワード」が一致している場合ログインできるように設定する
	 * @param email
	 * @param password
	 * @return
	 */
	public User userLogin(String email, String password) {
		User user = userMapper.findByEmailAndPassword(email, password);
		return user;
	}
	
	/**
	 * 投稿された質問の全件情報を取得する
	 */
	public List<Question> showQuestions() {
		List<Question> questionList = questionMapper.findByQuestions();
		return questionList;
	}
	
	/**
	 * 質問投稿
	 * @param question
	 */
	public void postQuestion(Question question) {
		questionMapper.insert(question);
	}
}
