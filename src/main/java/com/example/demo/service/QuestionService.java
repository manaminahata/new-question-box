package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Question;
import com.example.demo.repository.QuestionMapper;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionMapper questionMapper;
	
	public Question findByQuestionAndAnswer(int id) {
		Question question = questionMapper.findByQuestionAndAnswer(id);
		return question;
	}
}
