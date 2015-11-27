package cn.zucc.servlet01;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import sun.security.util.Password;

public class servlet001 extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub	
		System.out.println("sec");
	   /* String na = request.getParameter("name");
	    String pw = request.getParameter("password");
	  
		PrintWriter outname = response.getWriter();
		outname.write("<h1>the user name:</h1>");
		outname.write(na);
		outname.write("<h1>the password name:</h1>");
		outname.write(pw);*/
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
