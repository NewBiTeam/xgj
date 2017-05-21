package xgj.mcj.dao;

import java.util.List;

import xgj.mcj.entity.PageModel;
import xgj.mcj.entity.User;

public interface UserMapper {

	// 用户登录
	User login(User user);

	// 用户列表
	List<User> all();
	
	//个人信息
	User selectUserId(User user);
	
	//用户注册
	int add(User user);
	
	//分页查询
	void listUserWithPage(PageModel<User> pageModel);
	
	//查询所以数据（分页查询的准备）
	List<User> selectUserListWithPage(PageModel<User> pageModel);
	
	//查询数据的总数
	int selectUserCountWithPage(PageModel<User> pageModel);
	
}