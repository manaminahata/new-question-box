package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Question;
import com.example.demo.repository.QuestionMapper;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionMapper questionMapper;
	
//	/**
//	 * 質問を投稿する
//	 * @return
//	 */
//	public void postQuestion(String title, String question, int userId) {
//		questionMapper.insert(title, question, userId);
//	}
}
