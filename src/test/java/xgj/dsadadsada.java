package xgj;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import xgj.mcj.dao.StatementOfBillMapper;
import xgj.mcj.dao.UserMapper;
import xgj.mcj.entity.StatementOfBill;
import xgj.mcj.entity.User;

import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  

public class dsadadsada {

	@Resource UserMapper UserMapper;
	@Resource StatementOfBillMapper sob;
	
	@Test
	public void ss(){
		for(int i=0;i<200;i++){
			StatementOfBill sBill = new StatementOfBill();
			sBill.setNeirong(i+"我很好");
			sBill.setYue(Double.valueOf(i+1000));
			sBill.setYusuan(Double.valueOf(i+1000));
			sBill.setStartTime(new Date());
			sBill.setEndTime(new Date());
			sob.add(sBill);
		}
	}
	
	/*@Test
	public void ss(){
		for(int i=0;i<100000;i++){
			User user = new User();
			user.setAddress("address");
			user.setUsername("username");
			user.setTel("12345678914");
			user.setEmail("1234561456@qq.com");
			UserMapper.add(user);
		}
	}*/
	/* @Test  
	    public void HSSF()throws IOException{  
	        //第一步:创建一个工作簿excel文件  
		 	Workbook wb=new XSSFWorkbook();//打开一个模板文件，2007Excel以上版本 
	          
	        //第二步:创建一个工作表sheet  
	        Sheet sheet=wb.createSheet();  
	          
	        //第三步:创建一个行对象(我们放在第4行)  
	        Row nRow=sheet.createRow(8);//从0开始  
	          
	        //第四步:创建一个单元格对象，指定列  
	        //createCell参数有两个，一个是第几列一个是参数类型，  
	        //这里我们使用默认参数类型  
	        Cell nCell=nRow.createCell(1);  
	          List<User> list = UserMapper.all();
	        //第五步:给单元格设置内容 
	          User user = new User();
	          for(int i=0;i<list.size();i++){
	        	  user.setUsername(list.get(i).getUsername());
	        	  user.setAddress(list.get(i).getAddress());
	        	  user.setTel(list.get(i).getTel());
	        	  user.setEmail(list.get(i).getEmail());
	        	  nCell.setCellValue(user.getUsername()+user.getAddress()+user.getTel()+user.getEmail());
	          }
	         
	          
	        //第六步:保存  
	        OutputStream os=new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\mcj.xls"));  
	        wb.write(os);  
	          
	        //第七步:关闭  
	        os.close();  
	          
	    }  */
}

