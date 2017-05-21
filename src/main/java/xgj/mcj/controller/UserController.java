package xgj.mcj.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import xgj.mcj.entity.POIUtil;
import xgj.mcj.entity.PageModel;
import xgj.mcj.entity.User;
import xgj.mcj.service.UserService;

@Controller
@RequestMapping("/user/*")
@SessionAttributes("user")
public class UserController {

	@Resource
	UserService uService;
	Logger logger = Logger.getLogger(this.getClass());

	//用户列表
	@RequestMapping(value = "/all" , method = RequestMethod.POST)
	public @ResponseBody List<User> all(User user){
		System.out.println(user.getId()+"=====毛超杰");
		return uService.all();
	}
	
	//个人信息
	@RequestMapping(value = "/id" , method = RequestMethod.GET)
	@ResponseBody
	public User selectUserId(User user){
		return uService.selectUserId(user);
	}
	
	//用户注册
	@RequestMapping(value = "/add" , method = RequestMethod.POST)
	@ResponseBody
	public void add(User user){
		 uService.add(user);
	}
	
	//分页查询
	@RequestMapping(value = "/page")
    @ResponseBody
    public Object listUserWithPageForJson(PageModel pageModel,User user) {
        Object jsonObject = null;
        try {
            /*pageModel.setQueryObj(user);*/
            uService.listUserWithPage(pageModel);
            jsonObject = JSONObject.toJSON(pageModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
	private ServletContext servletContext;  
	/*开发者数据导出功能*/
	@RequestMapping(value = "/export")
	@ResponseBody
	public void Export(HttpServletRequest request,HttpServletResponse response) throws IOException {	
		 
		String download =request.getSession().getServletContext().getRealPath("/");
		File newFile = new File(download + File.separator + "download"
				+ new Date().getTime() + ".xls");
		User user = new User();
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
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型  
        response.setContentType("multipart/form-data");  
        //2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.xls)  
        response.setHeader("Content-Disposition", inlineType+";fileName="+"download.xls");  
        //通过文件路径获得File对象(假如此路径中有一个download.xls文件)  
        response.setContentLength((int) newFile.length());
		}
		
        Integer pageNum = 1;
		if (request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));					
		}

		List<User> users = uService.all();
				
		
		 List<Map<String, Object>> headInfoList = new ArrayList<Map<String,Object>>(); 
         Map<String, Object> itemMap = new HashMap<String, Object>(); 
         itemMap.put("title", "用户名"); 
         itemMap.put("columnWidth", 25); 
         itemMap.put("dataKey", "XH1"); 
         headInfoList.add(itemMap); 
         
         itemMap = new HashMap<String, Object>(); 
         itemMap.put("title", "地址"); 
         itemMap.put("columnWidth", 50); 
         itemMap.put("dataKey", "XH2"); 
         headInfoList.add(itemMap); 
         
         itemMap = new HashMap<String, Object>(); 
         itemMap.put("title", "手机号"); 
         itemMap.put("columnWidth", 50); 
         itemMap.put("dataKey", "XH3"); 
         headInfoList.add(itemMap); 
 
         itemMap = new HashMap<String, Object>(); 
         itemMap.put("title", "邮箱"); 
         itemMap.put("columnWidth", 50); 
         itemMap.put("dataKey", "XH4"); 
         headInfoList.add(itemMap); 
 
         List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>(); 
         Map<String, Object> dataItem = null; 
         for(int i=0; i < users.size(); i++){ 
         dataItem = new HashMap<String, Object>(); 
         User de=users.get(i);
         dataItem.put("XH1", ""+de.getUsername()); 
         dataItem.put("XH2", ""+de.getAddress()); 
         dataItem.put("XH3", ""+de.getTel()); 
         dataItem.put("XH4", ""+de.getEmail()); 
         dataList.add(dataItem); 
         } 
         POIUtil.exportExcel2FilePath("用户列表信息","C:/Users/Administrator/Desktop/shskjhk.xls"/*/newFile*/, headInfoList, dataList); 
		

	}
	
}
