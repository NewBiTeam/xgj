package xgj.mcj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xgj.mcj.dao.UserMapper;
import xgj.mcj.entity.PageModel;
import xgj.mcj.entity.User;
import xgj.mcj.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource UserMapper uMapper;
	
	public User login(User user) {
		return uMapper.login(user);
	}

	public List<User> all() {
		return uMapper.all();
	}

	public User selectUserId(User user) {
		return uMapper.selectUserId(user);
	}

	@Override
	public int add(User user) {
		return uMapper.add(user);
	}

	@Override
	public void listUserWithPage(PageModel<User> pageModel) {
		pageModel.setRows(uMapper.selectUserListWithPage(pageModel));
		pageModel.setTotal(uMapper.selectUserCountWithPage(pageModel));
		
	}

}
