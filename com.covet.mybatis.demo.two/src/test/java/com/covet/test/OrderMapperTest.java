package com.covet.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.covet.domain.Order;
import com.covet.mapper.OrderMapper;

public class OrderMapperTest {
	SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init () throws IOException{
		  this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("SqlMapConfig.xml"));
	}
	
	/**
	 * 查询所有order  解决数据库与实体类映射不一致 显示字段不能正常显示的问题
	 */
	@Test
	public void testQueryAllOrder(){
		SqlSession session = sqlSessionFactory.openSession();
		OrderMapper orderMapper = session.getMapper(OrderMapper.class);
		List<Order> order = orderMapper.queryAllOrder();
		for (Order order2 : order) {
			System.err.println(order2);
		}
		session.close();
	}
	

}
