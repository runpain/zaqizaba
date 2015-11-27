package cn.zucc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.zucc.entity.Item;
import cn.zucc.entity.UserInfo;
import cn.zucc.service.OrderBizImpl;

public class OrderSevlet extends HttpServlet {
	OrderBizImpl orderBizImpl = new OrderBizImpl();
	
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
		HttpSession session=req.getSession();
		UserInfo user =(UserInfo)session.getAttribute("user");
		int pageNo="".equals(req.getParameter("pageNo"))?1:Integer.parseInt(req.getParameter("pageNo"));
		String username = user.getUserName();
		List<Item> list= orderBizImpl.findItembyName(username, pageNo);
		session.setAttribute("itemlist", list);
		req.getRequestDispatcher("orderlist.jsp").forward(req, resp);
	}

}
