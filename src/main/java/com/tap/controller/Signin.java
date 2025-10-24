package com.tap.controller;

import com.tap.modeal.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

import com.tap.DaoImple.UserImp;

@WebServlet("/Signin")
public class Signin extends HttpServlet {

    private UserImp userImp;

    @Override
    public void init() throws ServletException {
        userImp = new UserImp();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || role.isEmpty()) {
            resp.sendRedirect("signin.html?error=missingField");
            return;
        }

        String generatedUsername = generateUserName(name);

        Timestamp now = new Timestamp(System.currentTimeMillis());

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhoneNo(phone);
        user.setAddress(address);
        user.setUserName(generatedUsername);
        user.setPassword(password);
        user.setRole(role);
        user.setCreateDate(new Timestamp(System.currentTimeMillis()));
        user.setLastLogin(new Timestamp(System.currentTimeMillis()));
    
            
            
            int result = userImp.addUser(user);
            if (result > 0) {
            	 resp.sendRedirect("Login.html");
            } else {
            	 resp.sendRedirect("AlltypeLogin.jsp");
            }
        
    }

    private String generateUserName(String name) {
        String baseUsername = name.replaceAll("\\s", "").toLowerCase();
        int c = 1;
        String username = baseUsername;

        while (userImp.isUserExists(username)) {
            username = baseUsername + c;
            c++;
        }
        return username;
    }
}
