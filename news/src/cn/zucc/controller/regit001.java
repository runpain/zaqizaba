package cn.zucc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.zucc.entity.User;
import cn.zucc.service.UserRegit;

public class regit001 extends HttpServlet {
	
	UserRegit userRegit= new UserRegit();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String flag=req.getParameter("flag");
		if ("login".equals(flag)) {
			login(req, resp);
		}
		else if ("regist".equals(flag)) {
			regist(req, resp);
		}	
	}
	
	private void regist(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		String name =req.getParameter("name");
		String password =req.getParameter("password");
		int sex = Integer.parseInt(req.getParameter("sex"));
		String hobby="";
		String[] hobbyArr = req.getParameterValues("hobby");
		for(String str :hobbyArr){
			hobby = hobby +str+" ";
		}
		User user = new User();
		user.setHobby(hobby);
		user.setName(name);
		user.setPassword(password);
		user.setSex(sex);
		if(userRegit.regist(user)){
			resp.sendRedirect("login.jsp");
		}else {
			resp.getWriter().write("error");
			System.out.println("error");
		}
	}
	private void login(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		String name =req.getParameter("name");
		String password = req.getParameter("password");
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		if(userRegit.login(user)) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			
			resp.sendRedirect("press.do?flag=list");
		}else {
			resp.sendRedirect("login.jsp");
		}

	}
}
