package xgj.mcj.dao;

import java.util.List;

import xgj.mcj.entity.PageModel;
import xgj.mcj.entity.StatementOfBill;

public interface StatementOfBillMapper {

	// ����֧�����
	List<StatementOfBill> all();

	void insert(StatementOfBill statementOfBill);

	// ��ҳ��ѯ
	List<StatementOfBill> selectPage(PageModel<StatementOfBill> model);
	
	//��ҳ��ѯ������
	int selectCount(PageModel<StatementOfBill> pageModel);
	
	//���
	void add(StatementOfBill statementOfBill);
	
	//ɾ��
	void del(StatementOfBill statementOfBill);
}