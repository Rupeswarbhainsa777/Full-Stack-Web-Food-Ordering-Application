package com.tap.Dao;
import com.tap.modeal.*;

import java.util.ArrayList;

public interface ResturantDao 
{


	
	void addRestaurant(Restaurant restaurant);
	
	Restaurant getRestaurant(int restaurantId);
	
	void updateRestaurant(Restaurant restaurant);
	
	void deleteRestaurant(int restaurantId);
	
	ArrayList<Restaurant> getAllRestaurant();

}
