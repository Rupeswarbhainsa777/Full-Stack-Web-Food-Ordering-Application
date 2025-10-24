package com.tap.modeal;

public class Restaurant
{
	
	

	private int restaurantId;
	private String name;
	private String imagepath;
	private int rating;
	private String eta;
	private String cuisineType;
	private String address;
	private boolean  isActive;
	private String restaurantOwnerId;
	
	public  Restaurant()
	{
		
	}

	public Restaurant(int restaurantId, String name, String imagepath, int rating, String eta, String cuisineType,
			String address, boolean isActive, String restaurantOwnerId) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.imagepath = imagepath;
		this.rating = rating;
		this.eta = eta;
		this.cuisineType = cuisineType;
		this.address = address;
		this.isActive = isActive;
		this.restaurantOwnerId = restaurantOwnerId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getEta() {
		return eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getRestaurantOwnerId() {
		return restaurantOwnerId;
	}

	public void setRestaurantOwnerId(String restaurantOwnerId) {
		this.restaurantOwnerId = restaurantOwnerId;
	}
	
	
	
	
	


}
