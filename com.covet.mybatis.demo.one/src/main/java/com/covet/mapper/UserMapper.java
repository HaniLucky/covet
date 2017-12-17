package com.covet.mapper;

import java.util.List;

import com.covet.domain.User;

public interface UserMapper {
	User queryUserById(int id);

	List<User> queryUserByUsername1(String username);

	List<User> queryUserByUsername2(String username);

	void saveUser(User user);

	void updateUserById(User user);

	void deleteUserById(int id);

	Integer selectUserCount();

}
