package cn.zucc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.zucc.entity.Comment;
import cn.zucc.entity.Press;
import cn.zucc.util.page;



public class CommentDao extends BaseDao {
	public void addComment(Comment comment) {
		try {
			addressUrl();
			String sql = "insert into comment(pressId,ip,comcontent) values(?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, comment.getPressId());
			psmt.setString(2, comment.getIp());
			psmt.setString(3, comment.getComcontent());
			
			System.out.println(psmt);
			psmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ìí¼Ó´íÎó");
			e.printStackTrace();
		} finally {
			myClose();
		}
	}
	
	

	
}
