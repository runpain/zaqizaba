package cn.zucc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cn.zucc.entity.UserInfo;


public class UserInfoBiz extends BaseBiz {
	
	public void AddUserInfo(UserInfo userInfo) {
		try {
			addressUrl();
			String sql = "insert into UserInfo(userName,password,email) value(?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userInfo.getUserName());
			psmt.setString(2, userInfo.getPassword());
			psmt.setString(3, userInfo.getEmail());
		
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
			String sql = "delete from UserInfo where id =?";			
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
	public UserInfo UpdateUserInfo(UserInfo userInfo){
		try {
			addressUrl();
			String sql = "update UserInfo set userName =?,password=?,email=? where id =?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,userInfo.getUserName());
			psmt.setString(2, userInfo.getPassword());
			psmt.setString(3, userInfo.getEmail());
			psmt.setInt(4, userInfo.getId());
			System.out.println(psmt);
			psmt.execute();	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("∏¸–¬ ß∞‹");
		}
		finally{
			myClose();
		}
		return userInfo;
	}
	
	public UserInfo FindById(int id){
		UserInfo userInfo = new UserInfo();
		try {
			addressUrl();
			String sql = "select * from UserInfo where id =?";	
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if(rs.next()){
				userInfo.setId(rs.getInt("id"));
				userInfo.setUserName(rs.getString("name"));
				userInfo.setPassword(rs.getString("password"));
				userInfo.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			System.out.println("≤È—Ø ß∞‹");
			// TODO: handle exception
		}
		finally{
			myClose();
		}
		return userInfo;
	}
	
	public UserInfo FindByName(String userName){
		UserInfo userInfo = null;
		try {
			addressUrl();
			String sql = "select * from UserInfo where userName=?";	
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userName);
			rs = psmt.executeQuery();
			if(rs.next()){
				userInfo = new UserInfo();
				userInfo.setId(rs.getInt("id"));
				userInfo.setUserName(rs.getString("userName"));
				userInfo.setPassword(rs.getString("password"));
				userInfo.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			System.out.println("≤È—Ø ß∞‹");
			// TODO: handle exception
		}
		finally{
			myClose();
		}
		return userInfo;
	 
	}
	public List<UserInfo>  FindAll(){
		List<UserInfo> list=new ArrayList<UserInfo>();
		try {
			addressUrl();
		String sql = "select * from UserInfo ";
		psmt = conn.prepareStatement(sql);
		rs = psmt.executeQuery();
		while(rs.next()){
			UserInfo userInfo = new UserInfo();
			userInfo.setId(rs.getInt("id"));
			userInfo.setUserName(rs.getString("name"));
			userInfo.setPassword(rs.getString("password"));
			userInfo.setEmail(rs.getString("email"));
			list.add(userInfo);
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
	

