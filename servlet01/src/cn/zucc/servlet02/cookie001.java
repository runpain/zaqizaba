package cn.zucc.servlet02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class cookie001 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("sev");
		Date date = new Date();
		Cookie cookie = new Cookie("lasttime", date.toString());
		resp.addCookie(cookie);
		
		Cookie[] cookies = req.getCookies();
		for(int i=0;cookies!=null && i<cookies.length;i++){
			Cookie c = cookies[i];
			if ("lastime".equals(c.getName())) {
				PrintWriter output = resp.getWriter();
				output.write(c.getValue());				
			}
				
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destory");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
	}
	
	
	

}
