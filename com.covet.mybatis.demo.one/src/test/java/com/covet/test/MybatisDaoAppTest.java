package com.covet.test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.covet.dao.UserDao;
import com.covet.dao.impl.UserDaoImpl;
import com.covet.domain.User;

/**
 *  测试mybatisDao开发方式 
 */
public class MybatisDaoAppTest {

	SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() throws IOException {
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources
				.getResourceAsStream("SqlMapConfig.xml"));
	}

	@Test
	public void queryUserById() {
		UserDao userDao = new UserDaoImpl(this.sqlSessionFactory);
		User user = userDao.queryUserById(1);
			System.out.println(user);

		
	}
	
	@Test
	public void queryUserByUsername1() {
		UserDao userDao = new UserDaoImpl(this.sqlSessionFactory);
		List<User> userList = userDao.queryUserByUsername1("张");
		for (User user : userList) {
			System.out.println(user);

		}
	}

	@Test
	public void queryUserByUsername2() {
		UserDao userDao = new UserDaoImpl(this.sqlSessionFactory);
		List<User> userList = userDao.queryUserByUsername2("王");
		for (User user : userList) {
			System.out.println(user);

		}
	}

	@Test
	public void saveUser() {
		UserDao userDao = new UserDaoImpl(this.sqlSessionFactory);
		// 创建保存对象
		User user = new User();
		user.setUsername("刘备");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("蜀国");
		userDao.saveUser(user);
		System.out.println(user);
	}

	@Test
	public void updateUser() {
		UserDao userDao = new UserDaoImpl(this.sqlSessionFactory);
		// 创建保存对象
		User user = new User();
		user.setId(24);
		user.setUsername("刘备");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("蜀国");
		userDao.updateUser(user);
		System.out.println(user);
	}

	@Test
	public void deleteUserById() {
		UserDao userDao = new UserDaoImpl(this.sqlSessionFactory);
		userDao.deleteUserById(24);
	}

	@Test
	public void selectUserCount() {
		UserDao userDao = new UserDaoImpl(this.sqlSessionFactory);
		Integer count = userDao.selectUserCount();
		System.out.println(count);
	}

	
}
