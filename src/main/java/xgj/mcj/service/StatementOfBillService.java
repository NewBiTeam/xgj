package xgj.mcj.service;

import java.util.List;

import xgj.mcj.entity.PageModel;
import xgj.mcj.entity.StatementOfBill;

public interface StatementOfBillService {

	// ����֧�����
	List<StatementOfBill> all();

	// ��ҳ��ѯ
	void selectPage(PageModel<StatementOfBill> model);

	// ���
	void insert(StatementOfBill sBill);
	
	//ɾ��
	void del(StatementOfBill statementOfBill);
}
