package cn.zucc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

import cn.zucc.entity.Comment;
import cn.zucc.entity.Press;
import cn.zucc.entity.Topic;
import cn.zucc.entity.User;
import cn.zucc.util.page;

public class PressDao extends BaseDao {

	public void addPress(Press press) {
		try {
			addressUrl();
			String sql = "insert into press(topicId,title,summary,content,author) values(?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, press.getTopicId());
			psmt.setString(2, press.getTitle());
			psmt.setString(3, press.getSummary());
			psmt.setString(4, press.getContent());
			psmt.setString(5, press.getAuthor());
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
	
	public List<Press> findAll(int pageNo) {
		List<Press> list = new ArrayList<Press>();
		try {
			addressUrl();
			String sql = "select * from press limit ?,?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, page.getStart(pageNo));
			psmt.setInt(2, page.pageSize);
			System.out.println(psmt);
	
			psmt.execute();
			rs = psmt.executeQuery();
			while (rs.next()) {
				Press press = new Press();
				press.setId(rs.getInt("id"));
				press.setAuthor(rs.getString("author"));
				press.setContent(rs.getString("content"));
				press.setSummary(rs.getString("summary"));
				press.setTitle(rs.getString("title"));
				press.setTopicId(rs.getInt("topicId"));
				list.add(press);
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

	public Press FindById(int id) {
		Press press = null;
		List<Comment> comments = new ArrayList<Comment>();
		try {
			addressUrl();
			String sql = "select * from press inner join comment on press.id = comment.pressId where press.id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				if(press==null){
					press = new Press();
				press.setId(rs.getInt("id"));
				press.setAuthor(rs.getString("author"));
				press.setContent(rs.getString("content"));
				press.setSummary(rs.getString("summary"));
				press.setTitle(rs.getString("title"));
				press.setTopicId(rs.getInt("topicId"));
				}
				Comment comment = new Comment();
				comment.setComcontent(rs.getString("comcontent"));
				comment.setCommentId(rs.getInt("commentId"));
				comment.setPressId(rs.getInt("pressId"));
				comment.setIp(rs.getString("ip"));
			}
			press.setComments(comments);
			System.out.println(psmt);
		} catch (Exception e) {
			System.out.println("≤È—Ø ß∞‹");
			// TODO: handle exception
		} finally {
			myClose();
		}
		return press;
	}

	public Press updatePress(Press press) {
		try {
			addressUrl();
			String sql = "update press set topicId =?,title=?,summary=?,content=?,author=? where id =?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, press.getTopicId());
			psmt.setString(2, press.getTitle());
			psmt.setString(3, press.getSummary());
			psmt.setString(4, press.getContent());
			psmt.setString(5, press.getAuthor());
			psmt.setInt(6, press.getId());
			System.out.println(psmt);
			psmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("∏¸–¬ ß∞‹");
		} finally {
			myClose();
		}
		return press;
	}
	
	public List<Press> findBykeyword(String keyword,int pageNo){
		List<Press> list = new ArrayList<Press>();
		try {
			addressUrl();
			StringBuffer sb = new StringBuffer();
			sb.append("select * from press where author like '%");
			sb.append(keyword);
			sb.append("%' or summary like '%");
			sb.append(keyword);
			sb.append("%' or title like '%");
			sb.append(keyword);
			sb.append("%' or content like '%");
			sb.append(keyword);
			sb.append("%'");
			sb.append("limit ?,?");
			psmt = conn.prepareStatement(sb.toString());
			psmt.setInt(1, page.getStart(pageNo));
			psmt.setInt(2, page.pageSize);
			System.out.println(psmt);
			
			rs = psmt.executeQuery();
			while(rs.next()){
				Press press = new Press();
				press.setId(rs.getInt("id"));
				press.setAuthor(rs.getString("author"));
				press.setContent(rs.getString("content"));
				press.setSummary(rs.getString("summary"));
				press.setTitle(rs.getString("title"));
				press.setTopicId(rs.getInt("topicId"));
				list.add(press);
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
			String sql = "select count(*) as totalCount from press";
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
			sb.append("select count(*) as totalCount from press where author like '%");
			sb.append(keyword);
			sb.append("%' or summary like '%");
			sb.append(keyword);
			sb.append("%' or title like '%");
			sb.append(keyword);
			sb.append("%' or content like '%");
			sb.append(keyword);
			sb.append("%'");
		
			psmt = conn.prepareStatement(sb.toString());
		
			System.out.println(sb);
			
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
