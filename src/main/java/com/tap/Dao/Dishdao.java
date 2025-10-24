package com.tap.Dao;
import java.util.*;

import com.tap.modeal.Dish;

public interface Dishdao 
{
	Dish getSpecialDish();
   List<Dish> getAllDishes();
}
