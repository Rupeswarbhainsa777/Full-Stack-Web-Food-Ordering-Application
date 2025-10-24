
package com.tap.controller;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.Date;



import com.tap.modeal.Cart;
import com.tap.modeal.CartItem;
import com.tap.DaoImple.OrdersImp;
import com.tap.modeal.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.tap.modeal.Orders;

@WebServlet("/ChecketOutServlet")
public class ChecketOutServlet extends HttpServlet 

{

    private OrdersImp orderImp;

    public void init() {
        orderImp = new OrdersImp();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("User");  // Correct attribute name

        if (cart != null ) 
        {

            double totalPrice = 0;
            for (CartItem item : cart.getItems().values()) {
                totalPrice += item.getPrice() * item.getQuantity();
                
                
            }
            session.setAttribute("totalPrice", totalPrice);
        }
        else
        {
        	String paymentMethod = req.getParameter("paymentMethod");
        

			

			 Orders order = new Orders();
	            order.setRestaurantId((int) session.getAttribute("restaurantId"));
	            order.setUserId(user.getUserId());
	            order.setPaymentMode(paymentMethod);
	            order.setStatus("Pending");
	            order.setOrderDate(new Timestamp(new Date().getTime()));
	       


	            orderImp.addOrder(order);

			session.removeAttribute("cart");
			session.setAttribute("order", order);
        	
        	
        }
        resp.sendRedirect("confirm.jsp");

           
            
          

       
    }
}
