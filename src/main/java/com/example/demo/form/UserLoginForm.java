package com.example.demo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * ユーザーログイン用
 * @author manami
 *
 */
public class UserLoginForm {
	/* メールアドレス */
	@NotEmpty(message = "メールアドレスが空欄です。")
	@Email(message = "メールアドレスの形式が不正です。")
	private String email;
	/* パスワード */
	@NotEmpty(message = "パスワードが空欄です。")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "パスワードの形式が不正です。")
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserLoginForm [email=" + email + ", password=" + password + "]";
	}
}
