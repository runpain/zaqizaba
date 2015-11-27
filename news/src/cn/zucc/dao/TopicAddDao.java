package cn.zucc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.zucc.entity.Press;
import cn.zucc.entity.Topic;
import cn.zucc.util.page;
import cn.zucc.util.topicpage;

public class TopicAddDao extends BaseDao {

	public void topicadd(Topic topic) {
		try {
			addressUrl();
			String sql = "insert into topic(name) value(?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, topic.getName());
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
	public List<Topic> findAll(int pageNo){
		List<Topic> list = new ArrayList<Topic>();
		try {
			addressUrl();
			String sql = "select * from topic limit ?,?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, page.getStart(pageNo));
			psmt.setInt(2, page.pageSize);
			System.out.println(psmt);
			psmt.execute();
			rs = psmt.executeQuery();
			while(rs.next()){
				Topic topic = new Topic();
				topic.setId(rs.getInt("id"));
				topic.setName(rs.getString("name"));
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
	
	public List<Topic> findAll(){
		List<Topic> list = new ArrayList<Topic>();
		try {
			addressUrl();
			String sql = "select * from topic ";
			psmt = conn.prepareStatement(sql);
			psmt.execute();
			rs = psmt.executeQuery();
			while(rs.next()){
				Topic topic = new Topic();
				topic.setId(rs.getInt("id"));
				topic.setName(rs.getString("name"));
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
	
	public Topic FindById(int id) {
		Topic topic = null;
		try {
			addressUrl();
			String sql = "select * from topic where id =?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				topic = new Topic();
				topic.setId(rs.getInt("id"));
				topic.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			System.out.println("≤È—Ø ß∞‹");
			// TODO: handle exception
		} finally {
			myClose();
		}
		return topic;
	}
	
	
	public Topic updatetTopic(Topic topic) {
		try {
			addressUrl();
			String sql = "update topic set name=? where id =?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,topic.getName());
			psmt.setInt(2, topic.getId());
			System.out.println(psmt);
			psmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("∏¸–¬ ß∞‹");
		} finally {
			myClose();
		}
		return topic;
	}
	
	public int Findcount() {
		int count=0;
		try {
			addressUrl();
			String sql = "select count(*) as totalCount from topic ";
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
	

