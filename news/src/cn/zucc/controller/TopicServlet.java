package cn.zucc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zucc.entity.Press;
import cn.zucc.entity.Topic;
import cn.zucc.service.TopicAdd;
import cn.zucc.util.page;
import cn.zucc.util.topicpage;

public class TopicServlet extends HttpServlet {
	TopicAdd topicAdd = new TopicAdd();

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
	
		String flag = req.getParameter("flag");
		
		
		if ("add".equals(flag)) {
			String name = req.getParameter("name");
			Topic topic = new Topic();
			topic.setName(name);
			topicAdd.addtopic(topic);
			resp.sendRedirect("press.do?flag=list");
		}else if ("list".equals(flag)) {
			int pageNo = "".equals(req.getParameter("pageNo"))?1:Integer.parseInt(req.getParameter("pageNo"));
			List<Topic> topicList = topicAdd.findAllTopic(pageNo);
			int totalPage = page.getTotalPage(topicAdd.getTotalCount());
			req.setAttribute("totalPage", totalPage);
			req.setAttribute("topicList", topicList);
			req.setAttribute("pageNo", pageNo);
			RequestDispatcher rd = req.getRequestDispatcher("topicShow.jsp");
			rd.forward(req, resp);
			
		}else if ("edit".equals(flag)) {
			
			int id = Integer.parseInt(req.getParameter("id"));
			Topic topic = topicAdd.findById(id);
		
			req.setAttribute("topic", topic);
			
			List<Topic> topicList = topicAdd.findAllTopic();
			req.setAttribute("topicList", topicList);
			req.getRequestDispatcher("topicedit.jsp").forward(req, resp);
			
		}else if ("update".equals(flag)) {
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			
			Topic topic = new Topic();
			topic.setId(id);
			topic.setName(name);
			
			topicAdd.updateTopic(topic);
			resp.sendRedirect("topic.do?flag=list");
		}
	}

}
