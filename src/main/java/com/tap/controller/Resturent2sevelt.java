package com.tap.controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tap.DaoImple.DishDAOImp;
import com.tap.DaoImple.RestaurantImp;
import com.tap.modeal.Dish;
//import com.tap.DaoImple.UserImp;
import com.tap.modeal.Restaurant;


/**
 * Servlet implementation class Resturent2sevelt
 */
@WebServlet("/Resturent2sevelt")
public class Resturent2sevelt extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    RestaurantImp rest = new RestaurantImp();
	    ArrayList<Restaurant> restaurant = rest.getAllRestaurant();
	    DishDAOImp disDao = new DishDAOImp();

		List<Dish> dishlist = disDao.getAllDishes();
      
		HttpSession sess = req.getSession();
		sess.setAttribute("restaurant", restaurant);
		sess.setAttribute("dishlist", dishlist);
		
		
		
		
		
		
		 RequestDispatcher rd = req.getRequestDispatcher("resturent.jsp");
	
	  
	    rd.forward(req, resp);
	
	}

}
