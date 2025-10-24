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

import com.tap.DaoImple.MenuImp;
import com.tap.modeal.Menu;

@WebServlet("/MenuResturent")
public class MenuResturent extends HttpServlet {
	MenuImp menuimp = new MenuImp();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    HttpSession session = req.getSession();
	    ArrayList<Menu> listmenu = (ArrayList<Menu>) menuimp.getAll();  // use field instance
	    session.setAttribute("listmenu", listmenu);
	    RequestDispatcher rd = req.getRequestDispatcher("normal.jsp");
	    rd.forward(req, resp);
	}


}
