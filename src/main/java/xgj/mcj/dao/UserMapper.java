package xgj.mcj.dao;

import java.util.List;

import xgj.mcj.entity.PageModel;
import xgj.mcj.entity.User;

public interface UserMapper {

	// �û���¼
	User login(User user);

	// �û��б�
	List<User> all();
	
	//������Ϣ
	User selectUserId(User user);
	
	//�û�ע��
	int add(User user);
	
	//��ҳ��ѯ
	void listUserWithPage(PageModel<User> pageModel);
	
	//��ѯ�������ݣ���ҳ��ѯ��׼����
	List<User> selectUserListWithPage(PageModel<User> pageModel);
	
	//��ѯ���ݵ�����
	int selectUserCountWithPage(PageModel<User> pageModel);
	
}