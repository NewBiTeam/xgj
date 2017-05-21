package xgj.mcj.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import xgj.mcj.entity.User;
import xgj.mcj.service.UserService;

@Controller
@RequestMapping("/user/*")
public class LoginController {

	@Resource
	UserService uService;

	@RequestMapping("/index")
	public String ss() {
		return "page/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public User ss(User user,HttpSession session) {

		user =uService.login(user);
		session.setAttribute("user", user);
		if(user == null){
			
		}
		
		return user;
	}

}
