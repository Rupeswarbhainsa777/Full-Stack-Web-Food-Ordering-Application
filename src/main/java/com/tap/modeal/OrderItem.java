package com.tap.modeal;

public class OrderItem {
	private int orderItemId;
	private int userId;
	private int menuId;

	private int quantity;

	private double price;
	
	public OrderItem() {
		
	}

	public OrderItem(int userId, int menuId, int quantity,
			double price) {
		super();
		
		this.userId = userId;
		this.menuId = menuId;
		
		this.quantity = quantity;
		this.price = price;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

	
	
	
}
