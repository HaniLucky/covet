package com.covet.test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.covet.domain.User;
import com.covet.mapper.UserMapper;

public class MybatisInterfaceAppTest {

	SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() throws IOException {

		this.sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
	}

	@Test
	public void queryUserById() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.queryUserById(1);
		System.out.println(user);
		sqlSession.close();
	}

	@Test
	public void queryUserByUsername1() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = userMapper.queryUserByUsername1("%张%");
		for (User user : userList) {
			System.out.println(user);

		}
		sqlSession.close();

	}

	@Test
	public void queryUserByUsername2() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = userMapper.queryUserByUsername2("王");
		for (User user : userList) {
			System.out.println(user);

		}
		sqlSession.close();

	}

	@Test
	public void saveUser() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 创建保存对象
		User user = new User();
		user.setUsername("刘备2");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("蜀国");
		userMapper.saveUser(user);
		sqlSession.commit();
		System.out.println(user);
		sqlSession.close();

	}

	@Test
	public void updateUser() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class); // 创建保存对象
		User user = new User();
		user.setId(34);
		user.setUsername("刘备update");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("蜀国");
		userMapper.updateUserById(user);
		sqlSession.commit();

		System.out.println(user);
		sqlSession.close();

	}

	@Test
	public void deleteUserById() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.deleteUserById(34);
		sqlSession.commit();
		sqlSession.close();

	}

	@Test
	public void selectUserCount() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		Integer count = userMapper.selectUserCount();
		System.out.println(count);
		sqlSession.close();

	}
}
