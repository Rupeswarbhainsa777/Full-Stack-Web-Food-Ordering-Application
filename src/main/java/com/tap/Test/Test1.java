package com.tap.Test;




import com.tap.Dao.*;
import com.tap.DaoImple.*;
import com.tap.modeal.User;

import java.sql.Timestamp;

public class Test1 {
    public static void main(String[] args)
    {
        UserDao dao = new UserImp();

        User user = new User();
        user.setName("Rupeswar");
        user.setEmail("rupeswar@example.com");
        user.setPhoneNo("9876543210");
        user.setAddress("Hyderabad");
        user.setUserName("rupes");
        user.setPassword("pass123");
        user.setRole("customer");
        user.setCreateDate(new Timestamp(System.currentTimeMillis()));
        user.setLastLogin(new Timestamp(System.currentTimeMillis()));

        int result = dao.addUser(user);
        if (result > 0) {
            System.out.println("User added successfully!");
        } else {
            System.out.println("Failed to add user.");
        }
    }
}
//package com.tap.controller;
//
//import com.tap.Dao.OrderDao;
//import com.tap.DaoImple.OrderItemImp;
//import com.tap.DaoImple.OrdersImp;
//import com.tap.modeal.Cart;
//import com.tap.modeal.CartItem;
//import com.tap.modeal.OrderItem;
//import com.tap.modeal.User;
//import com.tap.modeal.Orders;

//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//import java.sql.Timestamp;
//import java.util.Date;
//
//@WebServlet("/ChecketOutServlet")
//public class ChecketOutServlet extends HttpServlet {
//
//    private OrderDao orderDao;
//    private OrderItemImp orderItemDao;
//
//    public void init() {
//        orderDao = new OrdersImp();
//        orderItemDao = new OrderItemImp();
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        HttpSession session = req.getSession();
//        Cart cart = (Cart) session.getAttribute("cart");
//        User user = (User) session.getAttribute("user");
//
//        if (cart != null && user != null && !cart.getItems().isEmpty()) {
//            String paymentMethod = req.getParameter("paymentMethod");
////            String address = req.getParameter("address");
//
//            Orders order = new Orders();
//            order.setUserId(user.getUserId());
//            order.setOrderDate(new Timestamp(new Date().getTime()));
//            order.setPaymentMode(paymentMethod);
//            order.setStatus("pending");
//          // ✅ set address
//
//            double totalAmount = 0;
//            for (CartItem item : cart.getItems().values()) {
//                totalAmount += item.getPrice() * item.getQuantity();
//            }
//            order.setTotalAmount(totalAmount);
//
//            // Save Order
//            int orderId = orderDao.addOrder(order);
//            order.setOrderId(orderId); // ✅ Important: set the generated order ID back
//
//            // Save all Order Items
//            for (CartItem item : cart.getItems().values()) {
//                int itemId = item.getItemId();
//                double price = item.getPrice();
//                int quantity = item.getQuantity();
//                double totalPrice = price * quantity;
//
//                OrderItem orderItem = new OrderItem( itemId, orderId,quantity, totalPrice);
//                orderItemDao.addOrderItem(orderItem);
//            }
//
//            // Clear Cart
//            session.removeAttribute("cart");
//            session.setAttribute("order", order);
//
//            // Redirect to confirmation page
//            resp.sendRedirect("confirm.jsp");
//
//        } else
//        {
//            resp.sendRedirect("cart.jsp"); // Empty cart or no user
//            
//        }
//    }
//}