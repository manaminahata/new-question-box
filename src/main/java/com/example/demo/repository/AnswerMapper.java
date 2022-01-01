package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Answer;

@Mapper
public interface AnswerMapper {
	
	/* 質問に対しての回答を投稿 */
	public void insert(Answer answer);
}
