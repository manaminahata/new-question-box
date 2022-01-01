package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.Question;


@Mapper
public interface QuestionMapper {

	/** ユーザー情報を登録する */
	public void insert(Question question);

	/* 質問と回答を同時に取得する */
	public List<Question> findByAll();
	
	/* idが一致する質問と回答を取得する（質問詳細画面） */
	public Question findByQuestionAndAnswer(@Param("id") int id);
	
    /** idが一致する質問を取得する */
    public Question findByOne(@Param("id") int id);

    /** 投稿された質問を編集する */
    public void updateQuestion(Question question);

    /** 投稿された質問を削除する */
    public void deleteQuestion(Integer id);
}
