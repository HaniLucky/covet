package com.covet.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.covet.domain.User;
import com.thoughtworks.xstream.XStream;

public class MybatisAppTest {

	private SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void init() throws IOException {

		// 1.创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

		// 2.加载SqlMapCongfig.xml配置文件
		InputStream inputStream = Resources
				.getResourceAsStream("SqlMapConfig.xml");

		// 创建SqlSessionFactory对象
		this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

	}

	/** 根据id进行查询user */
	@Test
	public void queryUserById() {

		// 创建sqlSession对象

		SqlSession session = sqlSessionFactory.openSession();

		// 5. 执行SqlSession对象执行查询，获取结果User
		// 第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
		User user = session.selectOne("queryUserById", 1);

		// 打印结果
		System.out.println(new XStream().toXML(user));

		// 释放资源
		session.close();
	}

	/** 根据username模糊查询用户 #取值的方式 */
	@Test
	public void queryUserByUsername1() {
		// 创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 执行sql语句
		List<User> userList = sqlSession.selectList("queryUserByUsername1",
				"%王%");

		// 打印结果
		for (User user : userList) {
			System.out.println(user);
		}

		// 释放资源
		sqlSession.close();
	}

	/** 根据username模糊查询用户 防止sql注入$取值的方式 */
	@Test
	public void queryUserByUsername2() {
		// 创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 执行sql语句
		List<User> userList = sqlSession
				.selectList("queryUserByUsername2", "王");

		// 打印结果
		for (User user : userList) {
			System.out.println(user);
		}

		// 释放资源
		sqlSession.close();
	}

	/** 保存用户 */
	@Test
	public void saveUser() {
		// 创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		User user = new User();
		user.setUsername("张飞");
		user.setSex("男");
		user.setBirthday(new Date());
		user.setAddress("昌平");

		// 执行sql
		sqlSession.insert("saveUser", user);

		System.out.println(user);
		// 事务提交
		sqlSession.commit();

		// 关闭资源
		sqlSession.close();
	}

	@Test
	public void updateUserById() {
		// 创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		User user = new User();
		user.setId(25);
		user.setUsername("张飞");
		user.setSex("男");
		user.setBirthday(new Date());
		user.setAddress("昌平");

		sqlSession.update("updateUserById", user);
		// 事务提交
		sqlSession.commit();

		// 关闭资源
		sqlSession.close();
	}

	@Test
	public void deleteUserById() {
		// 创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		sqlSession.delete("deleteUserById", 32);

		// 事务提交
		sqlSession.commit();

		// 关闭资源
		sqlSession.close();
	}

	/** 查询记录数 */
	@Test
	public void selectUserCount() {
		try {
			// 创建sqlSession对象
			SqlSession sqlSession = sqlSessionFactory.openSession();

			Integer count = sqlSession.selectOne("selectUserCount2");

			System.out.println(count);
			// 关闭资源
			sqlSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		
		}
		

		
	}
}
