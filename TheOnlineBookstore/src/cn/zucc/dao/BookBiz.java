package cn.zucc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cn.zucc.entity.Book;
import cn.zucc.util.page;

public class BookBiz  extends BaseBiz {

	public void addPress(Book book) {
		try {
			addressUrl();
			String sql = "insert into book(bookName,prine,images,stock) values(?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookName());
			psmt.setDouble(2, book.getPrice());
			psmt.setString(3, book.getImages());
			psmt.setInt(4, book.getStock());
		
			System.out.println(sql);
			psmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ÃÌº”¥ÌŒÛ");
			e.printStackTrace();
		} finally {
			myClose();
		}
	}
	
	public List<Book> findAll(int pageNo) {
		List<Book> list = new ArrayList<Book>();
		try {
			addressUrl();
			String sql = "select * from book limit ?,?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, page.getStart(pageNo));
			psmt.setInt(2, page.pageSize);
			psmt.execute();
			rs = psmt.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBid(rs.getInt("bid"));
				book.setBookName(rs.getString("bookName"));
				book.setPrice(rs.getDouble("price"));
				book.setImages(rs.getString("images"));
				book.setStock(rs.getInt("stock"));
				list.add(book);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("≤È—Ø¥ÌŒÛ");
			e.printStackTrace();
		} finally {
			myClose();
		}
		return list;
	}
	
	public List<Book> findAll(){
		List<Book> list = new ArrayList<Book>();
		try {
			addressUrl();
			String sql = "select * from book ";
			psmt = conn.prepareStatement(sql);
			psmt.execute();
			rs = psmt.executeQuery();
			while(rs.next()){
				Book book = new Book();
				book.setBid(rs.getInt("bid"));
				book.setBookName(rs.getString("bookName"));
				book.setPrice(rs.getDouble("price"));
				book.setImages(rs.getString("images"));
				book.setStock(rs.getInt("stock"));
				list.add(book);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("≤È—Ø¥ÌŒÛ");
			e.printStackTrace();
		}finally{
			myClose();
	}
		return list;
	}
	
	public Book FindById(int bid) {
		Book book= null;
		try {
			addressUrl();
			String sql = "select * from book where bid =?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bid);
			rs = psmt.executeQuery();
			if (rs.next()) {
				book = new Book();
				book.setBid(rs.getInt("bid"));
				book.setBookName(rs.getString("bookName"));
				book.setPrice(rs.getDouble("price"));
				book.setImages(rs.getString("images"));
				book.setStock(rs.getInt("stock"));
			}
		} catch (Exception e) {
			System.out.println("≤È—Ø ß∞‹");
			// TODO: handle exception
		} finally {
			myClose();
		}
		return book;
	}



	public Book updatePress(Book book) {
		try {
			addressUrl();
			String sql = "update book set bookName =?,price=?,images=?,stock=? where bid =?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookName());
			psmt.setDouble(2, book.getPrice());
			psmt.setString(3, book.getImages());
			psmt.setInt(4, book.getStock());
			psmt.setInt(5, book.getBid());
			System.out.println(psmt);
			psmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("∏¸–¬ ß∞‹");
		} finally {
			myClose();
		}
		return book;
	}
	
	public List<Book> findBykeyword(String keyword,int pageNo){
		List<Book> list = new ArrayList<Book>();
		try {
			addressUrl();
			StringBuffer sb = new StringBuffer();
			sb.append("select * from book where bookName like '%");
			sb.append(keyword);
			sb.append("%' or price like '%");
			sb.append(keyword);
			sb.append("%' or images like '%");
			sb.append(keyword);
			sb.append("%' or stock like '%");
			sb.append(keyword);
			sb.append("%'");
			sb.append("limit ?,?");
			psmt = conn.prepareStatement(sb.toString());
			psmt.setInt(1, page.getStart(pageNo));
			psmt.setInt(2, page.pageSize);
			System.out.println(psmt);
			
			rs = psmt.executeQuery();
			while(rs.next()){
				Book book = new Book();
				book.setBid(rs.getInt("bid"));
				book.setBookName(rs.getString("bookName"));
				book.setPrice(rs.getDouble("price"));
				book.setImages(rs.getString("images"));
				book.setStock(rs.getInt("stock"));
				list.add(book);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("≤È—Ø¥ÌŒÛ");
			e.printStackTrace();
		}finally{
			myClose();
	}
		return list;
	}
	
	
	public int findCount() {
		int count = 0;
		try {
			addressUrl();
			String sql = "select count(*) as totalCount from book";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("totalCount");
			}
		} catch (Exception e) {
			System.out.println("≤È—Ø ß∞‹");
			// TODO: handle exception
		} finally {
			myClose();
		}
		return count;
	}
	
	
	public int findCountByCondition(String keyword,int pageNo){
		int count = 0;
		try {
			addressUrl();
			StringBuffer sb = new StringBuffer();
			sb.append("select count(*) as totalCount from book where bookName like '%");
			sb.append(keyword);
			sb.append("%' or price like '%");
			sb.append(keyword);
			sb.append("%' or images like '%");
			sb.append(keyword);
			sb.append("%' or stock like '%");
			sb.append(keyword);
			sb.append("%'");
		
			psmt = conn.prepareStatement(sb.toString());
		
			rs = psmt.executeQuery();
			if(rs.next()){
				count = rs.getInt("totalCount");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("≤È—Ø¥ÌŒÛ");
			e.printStackTrace();
		}finally{
			myClose();
	}
		return count;
	}
	
	
}
	
