package com.tap.Dao;
import com.tap.modeal.*;
import java.util.*;
public interface OrderDao 
{
 
	int addOrder(Orders ot);
	ArrayList<Orders> getAllOrders(int userId);
	Orders specificOrder(int restaurantId);
	
}

