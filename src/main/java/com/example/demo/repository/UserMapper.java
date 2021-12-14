package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.User;

/**
 * ユーザー情報とDBを繋ぐMapperインターフェイス
 * @author manami
 *
 */
@Mapper
public interface UserMapper {
	
	/** ユーザー情報を登録する */
	@Insert("insert into users(name, email, password, zipcode, address, telephone) \n"
			+ "        values(#{name},#{email},#{password},#{zipcode},#{address},#{telephone});")
	public void insert(User user);

    /** ユーザー情報を全件取得する */
	@Select("select * from users;")
    public List<User> findByUsers();

    /** idが一致するユーザーの情報を取得する */
	@Select("select * from users where id = #{id}")
    public User findByOne(Integer id);

    /** ユーザー情報を更新する */
    @Update("update users set name = #{name}, email = #{email}, password = #{password},"
			+ " zipcode = #{zipcode}, address = #{address}, telephone = #{telephone} where id = #{id};")
    public void updateUser(User user);

    /** ユーザー情報を削除する */
    @Delete("delete from users where id = #{id};")
    public void deleteUser(Integer id);
}
