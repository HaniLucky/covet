package com.covet.mapper;

import java.util.List;

import com.covet.domain.Order;
import com.covet.domain.OrderUser;
import com.covet.domain.QueryVo;
import com.covet.domain.User;

public interface UserMapper {
	/** 根据用户id查询用户 */
	User queryUserById(int id);

	/** 根据username进行用户查询  不能防止sql注入 */
	List<User> queryUserByUsername1(String username);

	/** 根据username进行用户查询  防止sql注入 */
	List<User> queryUserByUsername2(String username);

	/** 保存用户 */
	void saveUser(User user);

	/** 根据id进行更新 */
	void updateUserById(User user);

	/** 根据id进行删除 */
	void deleteUserById(int id);

	/** 查询总记录数 */
	Integer selectUserCount();
	
	/** 包装类vo查询 */
	List<User> queryUserByQueryVo(String username);
	
	/** 使用if条件进行条件查询  */
	List<User> queryUserByIf(User user);
	
	/** 使用where条件进行查询 */
	List<User> queryUserByWhere(User user);
	
	/** 使用where条件进行查询 (sql片段)*/
	List<User> queryUserByWhere2(User user);
	
	/** 使用where条件进行查询 (引用别的sql片段)*/
	List<User> queryUserByWhere3(User user);
	
	/** 使用foreach条件进行查询*/
	List<User> queryUserByIds(QueryVo queryVo);
	
	/** 一对一查询 resultType方式*/
	List<OrderUser> queryOrderUser();
	
	/** 一对一查询  resultMap方式*/
	List<Order> queryOrderByResultMap();
	
	/** 多对多查询 */
	List<User> queryUserOrder();

}
