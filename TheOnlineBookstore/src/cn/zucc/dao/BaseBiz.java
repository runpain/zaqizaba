package cn.zucc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseBiz {

	Connection conn = null;
	ResultSet rs = null;
	protected PreparedStatement psmt = null;
	public void myClose(){
		try{
			if (rs!=null) {
				rs.close();
			}
			if (psmt!=null) {
				psmt.close();
			}
			if (conn!=null) {
				conn.close();
			}		
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public BaseBiz() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Î´ÕÒµ½Çý¶¯£¡");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addressUrl()throws SQLException{
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/theonlinebookstore", "root", "root");
	}
}


