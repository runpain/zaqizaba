package cn.zucc.service;

import java.util.List;

import cn.zucc.dao.OrderBiz;
import cn.zucc.entity.Item;
import cn.zucc.entity.Order;


public class OrderBizImpl {

	OrderBiz orderBiz = new OrderBiz();

	public void addOrder(Order order) {
		orderBiz.addOrder(order);
	}

	public List<Order> findAll() {
		return orderBiz.findAll();
	}

	public Order findById(int oid) {
		return orderBiz.FindById(oid);
	}

	public Order updateOrder(Order order) {
		return orderBiz.updatetOrder(order);
	}

	public List<Item> findItembyName(String username, int pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
