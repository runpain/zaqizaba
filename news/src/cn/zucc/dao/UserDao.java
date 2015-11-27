package cn.zucc.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;


import cn.zucc.entity.User;

public class UserDao extends BaseDao {

	public void AddUser(User user) {
		try {
			addressUrl();
			String sql = "insert into user(name,password,sex,hobby) value(?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getPassword());
			psmt.setInt(3, user.getSex());
			psmt.setString(4, user.getHobby());
			System.out.println(psmt);
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
	public void DeleteById(int id){
		try {
			addressUrl();
			String sql = "delete from user where id =?";			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.execute();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			myClose();
		}
	}
	public User UpdateUser(User user){
		try {
			addressUrl();
			String sql = "update user set name =?,password=?,sex=?,hobby=? where id =?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,user.getName());
			psmt.setString(2, user.getPassword());
			psmt.setInt(3, user.getSex());
			psmt.setString(4, user.getHobby());
			psmt.setInt(5, user.getId());
			System.out.println(psmt);
			psmt.execute();	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("∏¸–¬ ß∞‹");
		}
		finally{
			myClose();
		}
		return user;
	}
	
	public User FindById(int id){
		User user = new User();
		try {
			addressUrl();
			String sql = "select * from user where id =?";	
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if(rs.next()){
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getInt("sex"));
				user.setHobby(rs.getString("hobby"));
			}
		} catch (Exception e) {
			System.out.println("≤È—Ø ß∞‹");
			// TODO: handle exception
		}
		finally{
			myClose();
		}
		return user;
	}
	
	public User FindByName(String name){
		User user = null;
		try {
			addressUrl();
			String sql = "select * from user where name=?";	
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getInt("sex"));
				user.setHobby(rs.getString("hobby"));
			}
		} catch (Exception e) {
			System.out.println("≤È—Ø ß∞‹");
			// TODO: handle exception
		}
		finally{
			myClose();
		}
		return user;
	 
	}
	public List<User>  FindAll(){
		List<User> list=new ArrayList<User>();
		try {
			addressUrl();
		String sql = "select * from user ";
		psmt = conn.prepareStatement(sql);
		rs = psmt.executeQuery();
		while(rs.next()){
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setSex(rs.getInt("sex"));
			user.setHobby(rs.getString("hobby"));
			list.add(user);
			}
		}
		catch (Exception e){
			System.out.println(" ß∞‹");
			// TODO: handle exception
		}
		finally{
			myClose();
		}
		return list;
	}
}
	
	
	
