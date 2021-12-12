package com.example.service.copy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * ユーザー情報登録用
	 * @param user
	 */
	public void signUp(User user) {
		
		userMapper.insert(user);
		
		System.out.println(user);
	}
}
