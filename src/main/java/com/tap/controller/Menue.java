
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
import jakarta.*;

import com.tap.DaoImple.MenuImp;
import com.tap.modeal.Menu;

@WebServlet("/Menu")
public class Menue extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      	MenuImp menuDao = new MenuImp();
//		List<Menu> menuList = menuDao.getAll();
//
//		req.setAttribute("menuList", menuList);
//
//		// Forward to JSP page
//		RequestDispatcher rd = req.getRequestDispatcher("Menu.jsp");
//		rd.forward(req, resp);
//		
      	
      	int res = Integer.parseInt(req.getParameter("restaurantId"));
		
//		List<Menu> menuItems = menuDao.getAll(); 
      	List<Menu> menuItems = menuDao.getAllMenuByRestarent(res);
		HttpSession session = req.getSession();
		session.setAttribute("menuList", menuItems);

		
		RequestDispatcher rd = req.getRequestDispatcher("Menu.jsp");
		rd.forward(req, resp);


	}
}
