package com.covet.dao;

import java.util.List;

import com.covet.domain.User;

public interface UserDao {
	User queryUserById(int id);

	List<User> queryUserByUsername1(String username);

	List<User> queryUserByUsername2(String username);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserById(int id);

	Integer selectUserCount();
}
