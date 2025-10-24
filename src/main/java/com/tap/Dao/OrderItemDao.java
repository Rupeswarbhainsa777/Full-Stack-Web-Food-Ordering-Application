package com.tap.Dao;

import java.util.List;

import com.tap.modeal.OrderItem;

public interface OrderItemDao 
{
	    void addOrderItem(OrderItem orderItem);
		
		OrderItem getOrderItem(int orderItemId);
		
		void updateOrderItem(OrderItem orderItem);
		
		void deleteOrderItem(int orderItemId);
		
		
		
		List<OrderItem> getAll();

}
