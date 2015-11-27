package cn.zucc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zucc.entity.Comment;
import cn.zucc.entity.Press;
import cn.zucc.entity.Topic;
import cn.zucc.service.CommentSev;
import cn.zucc.service.PressSev;
import cn.zucc.service.TopicAdd;
import cn.zucc.util.page;

public class PressSevlet extends HttpServlet {
	PressSev pressSev = new PressSev();
	TopicAdd topicAdd = new TopicAdd();
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

		String flag = req.getParameter("flag");
		if ("add".equals(flag)) {
			String title = req.getParameter("title");
			String author = req.getParameter("author");
			String summary = req.getParameter("summary");
			String content = req.getParameter("content");
			int topicId = Integer.parseInt(req.getParameter("topicId"));

			Press press = new Press();
			press.setTitle(title);
			press.setAuthor(author);
			press.setSummary(summary);
			press.setContent(content);
			press.setTopicId(topicId);
			pressSev.addpress(press);
			resp.sendRedirect("press.do?flag=list");
			
		}else if("list".equals(flag)){
			int pageNo = "".equals(req.getParameter("pageNo"))?1:Integer.parseInt(req.getParameter("pageNo"));
			List<Press> newsList = pressSev.findAll(pageNo);
			int totalPage = page.getTotalPage(pressSev.getTotalCount());
			
			req.setAttribute("totalPage",totalPage);
			req.setAttribute("newsList", newsList);
			req.setAttribute("pageNo", pageNo);
			req.setAttribute("flag", "list");
			RequestDispatcher rd = req.getRequestDispatcher("PressShow.jsp");
			rd.forward(req, resp);
			
		}else if ("edit".equals(flag)) {
			int id = Integer.parseInt(req.getParameter("id"));
			Press press = pressSev.findById(id);
		
			req.setAttribute("press", press);
			List<Topic> topicList = topicAdd.findAllTopic();
			req.setAttribute("topicList", topicList);
			req.getRequestDispatcher("newsedit.jsp").forward(req, resp);
		}else if ("update".equals(flag)) {
			int id =Integer.parseInt(req.getParameter("id"));
			String title = req.getParameter("title");
			String author = req.getParameter("author");
			String summary = req.getParameter("summary");
			String content = req.getParameter("content");
			int topicId = Integer.parseInt(req.getParameter("topicId"));

			Press press = new Press();
			press.setId(id);
			press.setTitle(title);
			press.setAuthor(author);
			press.setSummary(summary);
			press.setContent(content);
			press.setTopicId(topicId);
			pressSev.updatePress(press);
			resp.sendRedirect("press.do?flag=list");
		}else if ("search".equals(flag)) {		
//			int pageNo = req.getParameter("pageNo")== null?1:Integer.parseInt(req.getParameter("pageNo"));
			int pageNo = "".equals(req.getParameter("pageNo"))?1:Integer.parseInt(req.getParameter("pageNo"));
			String keyword =req.getParameter("keyword");	
			int totalPage = page.getTotalPage(pressSev.searchCount(keyword, pageNo));
			List<Press> pressList =pressSev.searchPress(keyword,pageNo);
			req.setAttribute("totalPage",totalPage);
			req.setAttribute("newsList", pressList);
			req.setAttribute("pageNo", pageNo);
			req.setAttribute("flag", "search&keyword=" + keyword);
			req.setAttribute("keyword", keyword);
			req.getRequestDispatcher("PressShow.jsp").forward(req, resp);
			
		}else if ("detail".equals(flag)) {
			int id = Integer.parseInt(req.getParameter("id"));
			Press press = pressSev.findById(id);
			req.setAttribute("press", press);
			
			req.getRequestDispatcher("addcomment.jsp").forward(req, resp);
			
		}
		}
	
}