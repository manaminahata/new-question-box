package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Answer;
import com.example.demo.domain.Question;
import com.example.demo.domain.User;
import com.example.demo.repository.AnswerMapper;
import com.example.demo.repository.QuestionMapper;
import com.example.demo.repository.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private QuestionMapper questionMapper;
	
	@Autowired
	private AnswerMapper answerMapper;
	
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
	public List<Question> showQuestionList() {
		List<Question> questionList = questionMapper.findByAll();
		return questionList;
	}
	
	/**
	 * 質問投稿
	 * @param question
	 */
	public void postQuestion(Question question) {
		questionMapper.insert(question);
	}
	
	public void postAnswer(Answer answer) {
		answerMapper.insert(answer);
	}
}
