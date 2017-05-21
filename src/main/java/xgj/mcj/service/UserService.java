package xgj.mcj.service;

import java.util.List;

import xgj.mcj.entity.PageModel;
import xgj.mcj.entity.User;

public interface UserService {

	// 用户登录
	User login(User user);

	// 用户列表
	List<User> all();

	// 个人信息
	User selectUserId(User user);

	// 用户注册
	int add(User user);
	
	//分页查询
	void listUserWithPage(PageModel<User> pageModel);
}
