package cn.zucc.service;

import java.util.List;

import org.omg.CORBA.INTERNAL;

import cn.zucc.dao.TopicAddDao;
import cn.zucc.entity.Topic;

public class TopicAdd {
	TopicAddDao topicAddDao = new TopicAddDao();

	public void addtopic(Topic topic) {
		topicAddDao.topicadd(topic);
	}

	public List<Topic> findAllTopic(int pageNo) {
		return topicAddDao.findAll(pageNo);
	}
	public List<Topic> findAllTopic() {
		return topicAddDao.findAll();
	}
	public Topic updateTopic(Topic topic){
		return topicAddDao.updatetTopic(topic);
	}
	
	public Topic findById(int id){
		return topicAddDao.FindById(id);
	}
	public int getTotalCount(){
		return topicAddDao.Findcount();
	}

}