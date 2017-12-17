package com.covet.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.covet.domain.Order;
import com.covet.domain.OrderUser;
import com.covet.domain.QueryVo;
import com.covet.domain.User;
import com.covet.mapper.UserMapper;

public class UserMapperTest {

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

	}

	@Test
	public void queryUserByUsername1() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = userMapper.queryUserByUsername1("%张%");
		for (User user : userList) {
			System.out.println(user);

		}
	}

	@Test
	public void queryUserByUsername2() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = userMapper.queryUserByUsername2("王");
		for (User user : userList) {
			System.out.println(user);

		}
	}

	@Test
	public void saveUser() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 创建保存对象
		User user = new User();
		user.setUsername("刘备3");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("蜀国2");
		userMapper.saveUser(user);
		sqlSession.commit();
		System.out.println(user);
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
	}

	@Test
	public void deleteUserById() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.deleteUserById(34);
		sqlSession.commit();
	}

	@Test
	public void selectUserCount() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		Integer count = userMapper.selectUserCount();
		System.out.println(count);
	}

	@Test
	public void queryUserByQueryVo() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> count = userMapper.queryUserByQueryVo("%张%");
		for (User user : count) {
			System.out.println(user);
		}

	}

	
	@Test
	public void queryUserByIf(){
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setSex("1");
		//user.setUsername("张");
		List<User> u = mapper.queryUserByIf(user );
		for (User user2 : u) {
			System.err.println(user2);
		}
		sqlSession.close();
	}
	
	@Test
	public void queryUserByWhere(){
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		// user.setSex("1");
		user.setUsername("张");
		List<User> u = mapper.queryUserByWhere(user );
		for (User user2 : u) {
			System.err.println(user2);
		}
		sqlSession.close();
	}
	
	
	@Test
	public void queryUserByWhere2(){
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		 user.setSex("1");
		user.setUsername("张");
		List<User> u = mapper.queryUserByWhere2(user);
		for (User user2 : u) {
			System.err.println(user2);
		}
		sqlSession.close();
	}
	
	@Test
	public void queryUserByWhere3(){
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		 user.setSex("1");
		user.setUsername("张");
		List<User> u = mapper.queryUserByWhere3(user);
		for (User user2 : u) {
			System.err.println(user2);
		}
		sqlSession.close();
	}
	@Test
	public void queryUserByIds(){
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		QueryVo queryVo = new QueryVo();
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("10");
		list.add("16");
		queryVo.setIds(list);
		List<User> u = mapper.queryUserByIds(queryVo);
		for (User user2 : u) {
			System.err.println(user2);
		}
		sqlSession.close();
	}
	
	
	@Test
	public void queryOrderUser(){
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		List<OrderUser> u = mapper.queryOrderUser();
		for (OrderUser user2 : u) {
			System.err.println(user2);
		}
		sqlSession.close();
	}
	
	@Test
	public void queryOrderByResultMap(){
		try {
			SqlSession sqlSession = this.sqlSessionFactory.openSession();
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			
			  List<Order> o = mapper.queryOrderByResultMap();
			for (Order user2 : o) {
				System.err.println(user2);
				System.err.println(user2.getUser());
			}
			sqlSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void queryUserOrder(){
		try {
			SqlSession sqlSession = this.sqlSessionFactory.openSession();
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			
			  List<User> o = mapper.queryUserOrder();
			for (User user2 : o) {
				System.err.println(user2);
			}
			sqlSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
