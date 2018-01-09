package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Users;
import com.service.UsersService;


@Controller
@RequestMapping("/")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	public UsersController(){
		System.out.println("=======UsersController==========");
	}
	
	@RequestMapping(value="/toRegIndex")
	 public String  toRegIndex(){
		System.out.println("==========toRegIndex=================");
		//跳转到login文件夹里的reg，后缀jsp和myBatis项目下的那个文件夹在application-servlet里都配置好了
		return "login/reg";
	}
	
	@RequestMapping(value="/reg")
	public String reg(HttpServletRequest request,HttpServletResponse resp,Users users){
		String name=users.getUsername();
		String pwd=users.getPwd();
		if(name==null||"".equals(name)){
			request.setAttribute("msg", "用户名不能为空");
			//跳转到login文件夹里的reg
			System.out.println("wwww");
			return "login/reg";
			
		}
		if(pwd==null||"".equals(pwd)){
			request.setAttribute("msg", "密码不能为空");
			System.out.println("oooo");
			return "login/reg";
		}
		
		int result= usersService.addUsers(users);
		if(result>0)
		{
			//跳转到/WEB-INF/view/里的regsucess
			System.out.println("pppp");
			return "regsuccess";
		}
		else{
			//跳转到/WEB-INF/view/里的fail
			System.out.println("iiii");
			return "fail";
		}
			
		
	}

}
