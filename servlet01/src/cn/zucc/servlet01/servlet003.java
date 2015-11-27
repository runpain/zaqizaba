package cn.zucc.servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet003 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//resp.sendRedirect("servlet002");
		/*PrintWriter out = resp.getWriter();
		StringBuffer url= req.getRequestURL();
		String uri = req.getRequestURI();
		String re = req.getQueryString();
		out.print("<html>");
		out.write(url.toString());
		out.write("<br/>");
		out.write(uri);
		out.write("<br/>");
		out.write(re);
		out.print("<html>");*/
		RequestDispatcher rd = req.getRequestDispatcher("servlet002");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
