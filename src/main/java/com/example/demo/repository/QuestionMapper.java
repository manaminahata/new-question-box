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
	@Insert("insert into questions(title, question, user_id) values(#{title}, #{question}, #{userId});")
	public void insert(Question question);

    /** ユーザー情報を全件取得する */
	@Select("select questions.id as q_id, questions.title as q_title, questions.question as q_question, \n"
			+ "			answers.id as a_id, answers.answer as a_answer, answers.question_id as a_question_id\n"
			+ "				from questions left join answers on questions.id = answers.question_id\n"
			+ "					order by q_id desc, a_id desc;")
    public List<Question> findByQuestions();
	
    /** idが一致する質問を取得する */
	@Select("select * from questions where id = #{id}")
    public Question findByOne(@Param("id") int id);

    /** 投稿された質問を編集する */
    @Update("update questions set title = #{title}, question = #{question} where id = #{id};")
    public void updateQuestion(Question question);

    /** 投稿された質問を削除する */
    @Delete("delete from questions where id = #{id};")
    public void deleteQuestion(Integer id);
}
