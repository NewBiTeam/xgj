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

@RunWith(SpringJUnit4ClassRunner.class)     //��ʾ�̳���SpringJUnit4ClassRunner��  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  

public class dsadadsada {

	@Resource UserMapper UserMapper;
	@Resource StatementOfBillMapper sob;
	
	@Test
	public void ss(){
		for(int i=0;i<200;i++){
			StatementOfBill sBill = new StatementOfBill();
			sBill.setNeirong(i+"�Һܺ�");
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
	        //��һ��:����һ��������excel�ļ�  
		 	Workbook wb=new XSSFWorkbook();//��һ��ģ���ļ���2007Excel���ϰ汾 
	          
	        //�ڶ���:����һ��������sheet  
	        Sheet sheet=wb.createSheet();  
	          
	        //������:����һ���ж���(���Ƿ��ڵ�4��)  
	        Row nRow=sheet.createRow(8);//��0��ʼ  
	          
	        //���Ĳ�:����һ����Ԫ�����ָ����  
	        //createCell������������һ���ǵڼ���һ���ǲ������ͣ�  
	        //��������ʹ��Ĭ�ϲ�������  
	        Cell nCell=nRow.createCell(1);  
	          List<User> list = UserMapper.all();
	        //���岽:����Ԫ���������� 
	          User user = new User();
	          for(int i=0;i<list.size();i++){
	        	  user.setUsername(list.get(i).getUsername());
	        	  user.setAddress(list.get(i).getAddress());
	        	  user.setTel(list.get(i).getTel());
	        	  user.setEmail(list.get(i).getEmail());
	        	  nCell.setCellValue(user.getUsername()+user.getAddress()+user.getTel()+user.getEmail());
	          }
	         
	          
	        //������:����  
	        OutputStream os=new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\mcj.xls"));  
	        wb.write(os);  
	          
	        //���߲�:�ر�  
	        os.close();  
	          
	    }  */
}

