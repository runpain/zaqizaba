package cn.zucc.service;

import java.util.List;

import cn.zucc.dao.BookBiz;
import cn.zucc.entity.Book;


public class BookBizImpl {
	BookBiz bookBiz = new BookBiz();
	
	public void addpress(Book book){
		bookBiz.addPress(book);
	}
	
	public List<Book> findAll(int pageNo) {
		return bookBiz.findAll(pageNo);
	}

	public List<Book> findAll() {
		return bookBiz.findAll();
	}
	
	public Book findById(int bid){
		return bookBiz.FindById(bid);
	}
	
	public Book updatePress(Book book){
		return bookBiz.updatePress(book);
	}
	 
	public List<Book>  searchPress (String  keyword,int pageNo){
		 return bookBiz.findBykeyword(keyword,pageNo);
	}
	
	public int getTotalCount(){
		return bookBiz.findCount();
	}
	
	
	public int searchCount(String keyword,int pageNo){
		return bookBiz.findCountByCondition(keyword, pageNo);
	}
}