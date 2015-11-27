package cn.zucc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zucc.entity.Comment;
import cn.zucc.service.CommentSev;

public class CommentSevlet extends HttpServlet {
		CommentSev commentSev = new CommentSev();
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
		String ip = req.getLocalAddr();
		String comcontent = req.getParameter("comcontent");
		int pressId = Integer.parseInt(req.getParameter("pressId"));
		
			Comment comment = new Comment();
			comment.setPressId(pressId);
			comment.setIp(ip);
			comment.setComcontent(comcontent);
			commentSev.addcomment(comment);
			resp.sendRedirect("press.do?flag=detail&id=" + pressId);
	}
	

}
