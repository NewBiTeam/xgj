package xgj.mcj.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSONObject;

import xgj.mcj.entity.PageModel;
import xgj.mcj.entity.StatementOfBill;
import xgj.mcj.entity.User;
import xgj.mcj.service.StatementOfBillService;

@Controller
@RequestMapping("/sob/*")
@SessionAttributes("user")
public class StatementOfBillController {

	@Resource StatementOfBillService Sob;
	
	@RequestMapping("/all")
	public @ResponseBody List<StatementOfBill> all(){
		return Sob.all();
	}
	
	@RequestMapping("/page")
	public @ResponseBody Object selectPage(PageModel<StatementOfBill> model){
		 Object jsonObject = null;
	        try {
	            /*pageModel.setQueryObj(user);*/
	            Sob.selectPage(model);
	            jsonObject = JSONObject.toJSON(model);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return jsonObject;
		
	}
	
	@RequestMapping("/add")
	public @ResponseBody void insertSOB(StatementOfBill sBill,User user){
		/*DateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		sBill.setShouru(Double.valueOf(sBill.getShouru()));
		sBill.setZhichu(Double.valueOf(sBill.getZhichu()));
		sBill.setYusuan(Double.valueOf(sBill.getYusuan()));*/
		System.out.println(user.getId());
		sBill.setUserid(user.getId());
		Sob.insert(sBill);
	}
	
	@RequestMapping("/del")
	public @ResponseBody void delSOB(StatementOfBill sBill){
		
		Sob.del(sBill);
	}
}
