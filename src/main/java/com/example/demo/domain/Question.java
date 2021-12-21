package com.example.demo.domain;

import java.util.List;

/**
 * 質問用のドメイン
 * @author manami
 *
 */
public class Question {
	private int id;
	private String title;
	private String question;
	private List<Answer> answerList;
	private User user;
	private int userId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Answer> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", question=" + question + ", answerList=" + answerList
				+ ", user=" + user + ", userId=" + userId + "]";
	}
	
	
}
