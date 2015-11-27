package cn.zucc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zucc.entity.Book;
import cn.zucc.service.BookBizImpl;
import cn.zucc.util.page;

public class BookSevlet extends HttpServlet {

	
	BookBizImpl bookBizImpl = new BookBizImpl();
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
			List<Book> bookList = bookBizImpl.findAll(pageNo);
			int totalPage = page.getTotalPage(bookBizImpl.getTotalCount());

			req.setAttribute("totalPage", totalPage);
			req.setAttribute("bookList", bookList);
			req.setAttribute("pageNo", pageNo);
			req.setAttribute("flag", "list");
			
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);

		}else if ("search".equals(flag)) {

			int pageNo = "".equals(req.getParameter("pageNo")) ? 1 : Integer
					.parseInt(req.getParameter("pageNo"));
			String keyword = req.getParameter("keyword");
			int totalPage = page.getTotalPage(bookBizImpl.searchCount(keyword,
					pageNo));
			List<Book> bookList = bookBizImpl.searchPress(keyword, pageNo);
			req.setAttribute("totalPage", totalPage);
			req.setAttribute("bookList", bookList);
			req.setAttribute("pageNo", pageNo);
			req.setAttribute("flag", "search&keyword=" + keyword);
			req.setAttribute("keyword", keyword);
			req.getRequestDispatcher("index.jsp").forward(req, resp);

		}
	}

}
