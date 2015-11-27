package cn.zucc.service;

import java.util.List;


import cn.zucc.dao.ItemBiz;
import cn.zucc.entity.Item;


public class ItemBizImpl {
	ItemBiz itemBiz = new ItemBiz();
	public void addItem(Item item){
		itemBiz.addItem(item);
	}
	
	public List<Item> findAll(int pageNo) {
		return itemBiz.findAll(pageNo);
	}

	public List<Item> findAll() {
		return itemBiz.findAll();
	}
	
	public Item findById(int iid){
		return itemBiz.FindById(iid);
	}
	
	public Item updateItem(Item item){
		return itemBiz.updateItem(item);
	}
	 

	public int getTotalCount(){
		return itemBiz.findCount();
	}
	
	

}