package xgj.mcj.service;

import java.util.List;

import xgj.mcj.entity.PageModel;
import xgj.mcj.entity.User;

public interface UserService {

	// �û���¼
	User login(User user);

	// �û��б�
	List<User> all();

	// ������Ϣ
	User selectUserId(User user);

	// �û�ע��
	int add(User user);
	
	//��ҳ��ѯ
	void listUserWithPage(PageModel<User> pageModel);
}
