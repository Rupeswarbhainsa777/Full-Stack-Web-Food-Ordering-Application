





package com.tap.Dao;
import java.util.List;

import com.tap.modeal.*;

public interface HistoryDao
{
	void addOrderHistory(History orderHistory);

	History getOrderHistory(int oderHistoryId);

	void updateOrderHistory(History orderHistory);

	void deleteOrderHistory(int orderHistoryId);
	List<History> getAll();
}

