package com.tap.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.tap.modeal.*;
import com.tap.DaoImple.*;

import java.io.IOException;

@WebServlet("/Cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
       

        int newRestaurantId = Integer.parseInt(request.getParameter("restaurantId"));
        Integer currentRestaurantId = (Integer) session.getAttribute("restaurantId");

        if (cart == null || newRestaurantId != currentRestaurantId) {
            cart = new Cart();
            session.setAttribute("cart", cart);
            session.setAttribute("restaurantId", newRestaurantId);
        }

        String action = request.getParameter("action");
        
        if (action != null)
        {
        if (action.equals("add")) {
            addItemToCart(request, cart);
        } else if (action.equals("update")) {
           upadateCartItem(request, cart);
        } else if (action.equals("remove")) {
          removeItemFromCart(request, cart);
        }
        }
        session.setAttribute("cart", cart);
        response.sendRedirect("cart.jsp");
        
        
        
        
    }

    private void addItemToCart(HttpServletRequest request, Cart cart) {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String quantityStr = request.getParameter("quantity");
        int quantity = 1; // default quantity
        if (quantityStr != null && !quantityStr.isEmpty()) {
            quantity = Integer.parseInt(quantityStr);
        }


        MenuImp menud = new MenuImp();
        Menu menuItem = menud.getMenu(itemId);

        if (menuItem != null) {
            CartItem item = new CartItem(
                menuItem.getMenuId(),
                menuItem.getRestaurantId(),
                menuItem.getItemName(),
                quantity,
                menuItem.getItemPrice()
            );

            cart.addItem(item);
        }
    }
    
    private void upadateCartItem(HttpServletRequest request, Cart cart)
    {
    	   int itemId = Integer.parseInt(request.getParameter("itemId"));
//           int quantity = Integer.parseInt(request.getParameter("quantity"));
    	   
    	   String quantityStr = request.getParameter("quantity");
    	   int quantity = 1; // default quantity
    	   if (quantityStr != null && !quantityStr.isEmpty()) {
    	       quantity = Integer.parseInt(quantityStr);
    	   }


    	       cart.updateItem(itemId, quantity);
    }
    private void removeItemFromCart(HttpServletRequest request, Cart cart)
    {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        
        cart.removeItem(itemId);

    	
    }
    
    
    
}
