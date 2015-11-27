package cn.zucc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cn.zucc.entity.Item;
import cn.zucc.util.page;

public class ItemBiz  extends BaseBiz {
	public void addItem(Item item) {
		try {
			addressUrl();
			String sql = "insert into item(oid,bid,createDate,count,price,totalPrice) values(?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, item.getOid());
			psmt.setInt(2, item.getBid());
			psmt.setDate(3, item.getCreateDate());
			psmt.setInt(4, item.getCount());
			psmt.setDouble(5, item.getPrice());
			psmt.setDouble(6, item.getTotalPrice());
		
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
	
	public List<Item> findAll(int pageNo) {
		List<Item> list = new ArrayList<Item>();
		try {
			addressUrl();
			String sql = "select * from item limit ?,?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, page.getStart(pageNo));
			psmt.setInt(2, page.pageSize);
			psmt.execute();
			rs = psmt.executeQuery();
			while (rs.next()) {
				Item item = new Item();
				item.setBid(rs.getInt("iid"));
				item.setBid(rs.getInt("oid"));
				item.setBid(rs.getInt("bid"));
				item.setCreateDate(rs.getDate("createDate"));
				item.setCount(rs.getInt("count"));
				item.setPrice(rs.getDouble("price"));
				item.setTotalPrice(rs.getDouble("totalPrice"));
				list.add(item);
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
	
	public List<Item> findAll(){
		List<Item> list = new ArrayList<Item>();
		try {
			addressUrl();
			String sql = "select * from item ";
			psmt = conn.prepareStatement(sql);
			psmt.execute();
			rs = psmt.executeQuery();
			while(rs.next()){
				Item item = new Item();
				item.setBid(rs.getInt("iid"));
				item.setBid(rs.getInt("oid"));
				item.setBid(rs.getInt("bid"));
				item.setCreateDate(rs.getDate("createDate"));
				item.setCount(rs.getInt("count"));
				item.setPrice(rs.getDouble("price"));
				item.setTotalPrice(rs.getDouble("totalPrice"));
				list.add(item);
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
	
	public Item FindById(int iid) {
		Item item= null;
		try {
			addressUrl();
			String sql = "select * from item where iid =?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, iid);
			rs = psmt.executeQuery();
			if (rs.next()) {
				item = new Item();
				item.setBid(rs.getInt("iid"));
				item.setBid(rs.getInt("oid"));
				item.setBid(rs.getInt("bid"));
				item.setCreateDate(rs.getDate("createDate"));
				item.setCount(rs.getInt("count"));
				item.setPrice(rs.getDouble("price"));
				item.setTotalPrice(rs.getDouble("totalPrice"));
			}
		} catch (Exception e) {
			System.out.println("≤È—Ø ß∞‹");
			// TODO: handle exception
		} finally {
			myClose();
		}
		return item;
	}



	public Item updateItem(Item item) {
		try {
			addressUrl();
			String sql = "update book set oid=?,bid=?,createDate=?,count=?,price=?,totalPrice=? where iid =?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, item.getOid());
			psmt.setInt(2, item.getBid());
			psmt.setDate(3, item.getCreateDate());
			psmt.setInt(4, item.getCount());
			psmt.setDouble(5, item.getPrice());
			psmt.setDouble(6, item.getTotalPrice());
			psmt.setInt(7, item.getIid());
			System.out.println(psmt);
			psmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("∏¸–¬ ß∞‹");
		} finally {
			myClose();
		}
		return item;
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
	
	
	
	
}
	