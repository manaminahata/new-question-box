package com.example.demo.form;

/**
 * 質問に対しての回答を受け取るフォーム
 * @author manami
 *
 */
public class AnswerForm {
	/* 質問に対しての回答を取得 */
	private String answer;
	/* ユーザーIDを取得 */
	private int userId;
	/* 質問と紐づけるため、IDを取得 */
	private int questionId;
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
	@Override
	public String toString() {
		return "AnswerForm [answer=" + answer + ", userId=" + userId + ", questionId=" + questionId + "]";
	}
}
