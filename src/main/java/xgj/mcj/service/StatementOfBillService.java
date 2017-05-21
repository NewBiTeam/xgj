package xgj.mcj.service;

import java.util.List;

import xgj.mcj.entity.PageModel;
import xgj.mcj.entity.StatementOfBill;

public interface StatementOfBillService {

	// 收入支出情况
	List<StatementOfBill> all();

	// 分页查询
	void selectPage(PageModel<StatementOfBill> model);

	// 添加
	void insert(StatementOfBill sBill);
	
	//删除
	void del(StatementOfBill statementOfBill);
}
