package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.User;

/**
 * ユーザー情報とDBを繋ぐMapperインターフェイス
 * @author manami
 *
 */
@Mapper
public interface UserMapper {
	
	/** ユーザー情報を登録する */
	public void insert(User user);

    /** ユーザー情報を全件取得する */
    public List<User> findByUsers();

    /** idが一致するユーザーの情報を取得する */
    public User findByOne(Integer id);

    /** ユーザー情報を更新する */
    public void updateUser(User user);

    /** ユーザー情報を削除する */
    public void deleteUser(Integer id);
}
