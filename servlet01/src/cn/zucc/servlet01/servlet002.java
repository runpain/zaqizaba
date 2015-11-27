package cn.zucc.servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet002 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		System.out.println("get");
		
	/*	String na = req.getParameter("name"); 
		String  nameStr =new String(na.getBytes("ISO-8859-1"),"utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter outname = resp.getWriter();
		outname.write("<h1>the user name:</h1>");
		outname.write(nameStr);
		System.out.println(nameStr);
		String pw = req.getParameter("password");
		outname.write("<h1>the password :</h1>");
		outname.write(pw);*/
		
		/*ServletContext cox = this.getServletContext();
		cox.setAttribute("cox", "123");*/
		
		
		PrintWriter outname = resp.getWriter();
		outname.print("<html>");
		outname.print("come on,baby!<br/>This page is not the third,try again. ");
		outname.print("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		System.out.println("post");
	/*	req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		String na = req.getParameter("name");
		PrintWriter outname = resp.getWriter();
		outname.write("<h1>the user name:</h1>");
		outname.write(na);
		System.out.println(na);
		String pw = req.getParameter("password");
		outname.write("<h1>the password :</h1>");
		outname.write(pw);
		ServletContext cog = this.getServletContext();
		outname.write(cog.getInitParameter("zoo"));*/
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
	}

}
