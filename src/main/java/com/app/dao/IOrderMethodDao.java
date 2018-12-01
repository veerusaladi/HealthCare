package com.app.dao;

import java.util.List;

import com.app.model.OrderMethod;

public interface IOrderMethodDao {

	public int saveOrderMethod(OrderMethod om);
	public void updateOrderMethod(OrderMethod om);
	public void deleteOrderMethod(int id);
	public OrderMethod getOneOrderMethodById(int id);
	public List<OrderMethod> getAllOrderMethods();
	
}
