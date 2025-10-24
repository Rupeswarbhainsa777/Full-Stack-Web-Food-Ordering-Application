package com.tap.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.tap.DaoImple.DishDAOImp;
import com.tap.DaoImple.MenuImp;
import com.tap.modeal.Dish;
import com.tap.modeal.Menu;

@WebServlet("/MenuDis")
public class MenuDis extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DishDAOImp disDao = new DishDAOImp();

		List<Dish> dishlist = disDao.getAllDishes();

		HttpSession session = req.getSession();

		session.setAttribute("dishlist", dishlist);
		RequestDispatcher rd = req.getRequestDispatcher("resturent.jsp");
		rd.forward(req, resp);

	}
}
