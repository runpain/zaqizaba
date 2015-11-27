package cn.zucc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import cn.zucc.entity.Order;
import cn.zucc.util.page;

public class OrderBiz extends BaseBiz {
	public void addOrder(Order order) {
		try {
			addressUrl();
			String sql = "insert into orderlist(userName) value(?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, order.getUserName());
			psmt.execute();
		} catch (SQLException e) {
			System.out.println("≤Â»Î ß∞‹");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			myClose();
		}
		
	}
	public List<Order> findAll(int pageNo){
		List<Order> list = new ArrayList<Order>();
		try {
			addressUrl();
			String sql = "select * from orderlist limit ?,?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, page.getStart(pageNo));
			psmt.setInt(2, page.pageSize);
			System.out.println(psmt);
			psmt.execute();
			rs = psmt.executeQuery();
			while(rs.next()){
				Order topic = new Order();
				topic.setOid(rs.getInt("oid"));
				topic.setUserName(rs.getString("userName"));
				list.add(topic);
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
	
	public List<Order> findAll(){
		List<Order> list = new ArrayList<Order>();
		try {
			addressUrl();
			String sql = "select * from orderlist ";
			psmt = conn.prepareStatement(sql);
			psmt.execute();
			rs = psmt.executeQuery();
			while(rs.next()){
				Order topic = new Order();
				topic.setOid(rs.getInt("oid"));
				topic.setUserName(rs.getString("userName"));
				list.add(topic);
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
	
	public Order FindById(int oid) {
		Order order = null;
		try {
			addressUrl();
			String sql = "select * from orderlist where oid =?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, oid);
			rs = psmt.executeQuery();
			if (rs.next()) {
				order = new Order();
				order.setOid(rs.getInt("oid"));
				order.setUserName(rs.getString("userName"));
			}
		} catch (Exception e) {
			System.out.println("≤È—Ø ß∞‹");
			// TODO: handle exception
		} finally {
			myClose();
		}
		return order;
	}
	
	
	public Order updatetOrder(Order order) {
		try {
			addressUrl();
			String sql = "update orderlist set userName=? where oid =?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,order.getUserName());
			psmt.setInt(2, order.getOid());
			System.out.println(psmt);
			psmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("∏¸–¬ ß∞‹");
		} finally {
			myClose();
		}
		return order;
	}
	
	
}
	

