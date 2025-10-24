package com.tap.controller;

import com.tap.DaoImple.UserImp;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;






@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    private UserImp userImp;

    @Override
    public void init() throws ServletException {
        userImp = new UserImp();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session=      request.getSession();

        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            response.sendRedirect("Login.html?error=emptyFields");
            return;
        }

        boolean isValid = userImp.isValidUser(email, password);

        if (isValid) 
        {
          
        	
        	session.setAttribute("email", email);
			response.sendRedirect("Resturent2sevelt");
        	

        
        } else {
            response.sendRedirect("AlltypeLogin.jsp");
        }
    }
}
