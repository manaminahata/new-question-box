package com.example.demo.form;

public class QuestionForm {
	private int id;
	private String title;
	private String question;
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
	public int getUserId() {
		return userId;
	}
	public void setUser_id(int userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "QuestionForm [id=" + id + ", title=" + title + ", question=" + question + ", userId=" + userId + "]";
	}
	
}
