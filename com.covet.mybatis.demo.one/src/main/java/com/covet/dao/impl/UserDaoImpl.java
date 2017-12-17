package com.covet.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.covet.dao.UserDao;
import com.covet.domain.User;


/** mybatisDao开发方式 */
public class UserDaoImpl implements UserDao {

	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public User queryUserById(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("queryUserById", id);
		sqlSession.close();
		return user;
	}

	public List<User> queryUserByUsername1(String username) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> userList = sqlSession.selectList("queryUserByUsername1", "%"
				+ username + "%");
		sqlSession.close();
		return userList;
	}

	public List<User> queryUserByUsername2(String username) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> userList = sqlSession.selectList("queryUserByUsername2",
				username);
		sqlSession.close();
		return userList;
	}

	public void saveUser(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("saveUser", user);
		sqlSession.commit();
		sqlSession.close();

	}

	public void updateUser(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("updateUserById", user);
		sqlSession.commit();
		sqlSession.close();

	}

	public void deleteUserById(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("deleteUserById", id);
		sqlSession.commit();
		sqlSession.close();
	}

	public Integer selectUserCount() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Integer count = sqlSession.selectOne("selectUserCount");
		sqlSession.close();
		return count;
	}

}
