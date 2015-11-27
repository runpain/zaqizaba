package cn.zucc.service;

import java.util.List;

import cn.zucc.dao.PressDao;
import cn.zucc.dao.TopicAddDao;
import cn.zucc.entity.Press;
import cn.zucc.entity.Topic;

public class PressSev {
	
	PressDao pd = new PressDao();
	
	public void addpress(Press press){
		pd.addPress(press);
	}
	
	public List<Press> findAll(int pageNo) {
		return pd.findAll(pageNo);
	}

	public Press findById(int id){
		return pd.FindById(id);
	}
	
	public Press updatePress(Press press){
		return pd.updatePress(press);
	}
	 
	public List<Press>  searchPress (String  keyword,int pageNo){
		 return pd.findBykeyword(keyword,pageNo);
	}
	public int getTotalCount(){
		return pd.findCount();
	}
	
	
	public int searchCount(String keyword,int pageNo){
		return pd.findCountByCondition(keyword, pageNo);
	}
}
