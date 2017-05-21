package xgj.mcj.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xgj.mcj.entity.PoiExcelUtil;
import xgj.mcj.entity.User;
import xgj.mcj.service.UserService;

@Controller

public class ExcelController {

	@Resource UserService uService;
	
	@RequestMapping(value = "/exsport" , method = RequestMethod.GET)
	@ResponseBody
	public void excel(HttpServletRequest request ,HttpServletResponse response) throws IOException{
		String upload = request.getSession().getServletContext().getRealPath("/upload");
		String download =request.getSession().getServletContext().getRealPath("/");
		File tempFile = new File(upload + File.separator + "mcj.xls");
		File newFile = new File(download + File.separator + "download"
				+ new Date().getTime() + ".xls");
		List<User> data =null ;
		 data = uService.all();
		 if (newFile.exists()) {
			newFile.createNewFile();
		}
		 writeto_tglExcel(tempFile, newFile, data);
		 BufferedOutputStream output = null;
		 BufferedInputStream input = null;
		 try {
				if ((newFile.exists()) && (newFile.canRead())) {
					String mimetype = "application/octet-stream;charset=UTF-8";
					response.setContentType(mimetype);
	                String ua = request.getHeader("User-Agent");
					if (ua == null)
						ua = "User-Agent:Mozilla/4.0(compatible; MSIE 6.0;)";
					boolean isIE = ua.toLowerCase().indexOf("msie") != -1;
					if (isIE) {
						mimetype = "application/x-msdownload";
					}
	                String inlineType = "inline";
	                response.setHeader("Content-Disposition", inlineType + ";filename=download.xls");
					response.setContentLength((int) newFile.length());
					byte[] buffer = new byte[1024];
					output = new BufferedOutputStream(response.getOutputStream());
					input = new BufferedInputStream(new FileInputStream(newFile));
					int n = -1;
					while ((n = input.read(buffer, 0, 1024)) > -1) {
						output.write(buffer, 0, n);
					}
					response.flushBuffer();		
				}
			} catch (Exception e) {
				e.printStackTrace(); 
			} finally {
				if (input != null)
					input.close();
				if (output != null)
					output.close();
			}
	}
	
	private void writeto_tglExcel(File tempFile, File newFile,  List<User> data) {
		int count = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm:ss");
		List lists = new ArrayList();
		
		for(User user : data){
			List list = new ArrayList();
			if (user.getUsername() != null) {
				list.add(user.getUsername());
			}else {
				list.add("");
			}
			if (user.getAddress() != null) {
				list.add(user.getAddress());
			}else {
				list.add("");
			}
			if (user.getTel() != null) {
				list.add(user.getTel());
			}else {
				list.add("");
			}
			if (user.getEmail() != null) {
				list.add(user.getEmail());
			}else {
				list.add("");
			}
			lists.add(list);
		}
		PoiExcelUtil.workbookWrite1(tempFile, newFile, lists, 3, 0);
	}
}
