package com.tap.Dao;

import java.util.List;

import com.tap.modeal.Menu;


public interface MenuDao
{
    void addMenu(Menu menu);
	
	Menu getMenu(int menuId);
	
	void updateMenu(Menu menu);
	
	void deleteMenu(int menuId);
	
	List<Menu> getAllMenuByRestarent(int restaurantId);	
	
	public List<Menu> getAll();
	

}
