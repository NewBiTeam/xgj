package xgj.mcj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xgj.mcj.dao.StatementOfBillMapper;
import xgj.mcj.entity.PageModel;
import xgj.mcj.entity.StatementOfBill;
import xgj.mcj.service.StatementOfBillService;

@Service
public class StatementOfBillServiceImpl implements StatementOfBillService {

	@Resource StatementOfBillMapper Sob;
	
	@Override
	public List<StatementOfBill> all() {
		return Sob.all();
	}

	@Override
	public void selectPage(PageModel<StatementOfBill> model) {
		model.setRows(Sob.selectPage(model));
		model.setTotal(Sob.selectCount(model));
	}

	@Override
	public void insert(StatementOfBill sBill) {
		// TODO Auto-generated method stub
		Sob.add(sBill);
	}

	@Override
	public void del(StatementOfBill statementOfBill) {
		Sob.del(statementOfBill);
	}

}
