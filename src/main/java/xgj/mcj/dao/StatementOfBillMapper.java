package xgj.mcj.dao;

import java.util.List;

import xgj.mcj.entity.PageModel;
import xgj.mcj.entity.StatementOfBill;

public interface StatementOfBillMapper {

	// 收入支出情况
	List<StatementOfBill> all();

	void insert(StatementOfBill statementOfBill);

	// 分页查询
	List<StatementOfBill> selectPage(PageModel<StatementOfBill> model);
	
	//分页查询总数量
	int selectCount(PageModel<StatementOfBill> pageModel);
	
	//添加
	void add(StatementOfBill statementOfBill);
	
	//删除
	void del(StatementOfBill statementOfBill);
}