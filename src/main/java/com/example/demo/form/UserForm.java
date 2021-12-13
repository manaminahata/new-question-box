package com.example.demo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * ユーザー登録情報を受け取る
 * @author manami
 *
 */
public class UserForm {
	/* id */
	private int id;
	/* 名前 */
	@NotBlank(message = "「名前」は必須項目です。")
	private String name;
	/* メールアドレス */
	@NotBlank(message = "「メールアドレス」は必須項目です。")
	@Email(message = "メールアドレスの形式が不正です。")
	private String email;
	/* パスワード */
	@NotBlank(message = "「パスワード」は必須項目です。")
	@Size(min = 8, max = 16, message = "8文字以上16文字以下で入力してください。")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "半角英数字のどちらも利用してください。")
	private String password;
	/* 郵便番号 */
	@NotBlank(message = "「郵便番号」は必須項目です。")
	@Pattern(regexp = "^[0-9]{3}-[0-9]{4}$", message = "ハイフンを含んだ形式で入力してください。")
	private String zipcode;
	/* 住所 */
	@NotBlank(message = "「住所」は必須項目です。")
	private String address;
	/* 電話番号 */
	@NotBlank(message = "「電話番号」は必須項目です。")
	@Pattern(regexp = "^[0-9]{3}-[0-9]{4}-[0-9]{4}$", message = "ハイフンを含んだ形式で入力してください。")
	private String telephone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Override
	public String toString() {
		return "UserForm [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", zipcode="
				+ zipcode + ", address=" + address + ", telephone=" + telephone + "]";
	}
}
