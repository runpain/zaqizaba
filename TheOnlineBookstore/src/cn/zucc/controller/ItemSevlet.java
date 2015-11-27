package cn.zucc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zucc.entity.Book;
import cn.zucc.entity.Item;
import cn.zucc.service.ItemBizImpl;
import cn.zucc.util.page;

public class ItemSevlet extends HttpServlet {
	
	ItemBizImpl itemBizImpl = new ItemBizImpl();

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
		if ("list".equals(flag)) {
			int pageNo = "".equals(req.getParameter("pageNo")) ? 1 : Integer
					.parseInt(req.getParameter("pageNo"));
			List<Item> itemList = itemBizImpl.findAll(pageNo);
			int totalPage = page.getTotalPage(itemBizImpl.getTotalCount());

			req.setAttribute("totalPage", totalPage);
			req.setAttribute("itemList", itemList);
			req.setAttribute("pageNo", pageNo);
			req.setAttribute("flag", "list");

			RequestDispatcher rd = req.getRequestDispatcher("orderList.jsp");
			rd.forward(req, resp);

		}
		
	}
	
	

}
