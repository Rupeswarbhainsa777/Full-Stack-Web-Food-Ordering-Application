//package com.tap.Test;
//
//
//import java.util.ArrayList;
//import com.tap.modeal.Orders;
//import com.tap.Dao.OrderDao;
//import com.tap.DaoImple.OrdersImp;
//
//public class Test4 {
//
//    public static void main(String[] args) {
//
//        OrderDao dao = new OrdersImp();
//
//        // ✅ Test 1: Add a new order
//        Orders order = new Orders();
//        order.setUserId(1);              // change to existing user ID
//        order.setRestaurantId(101);      // change to existing restaurant ID
//        order.setTotalAmount(349.99);
//        order.setStatus("confirmed");
//        order.setPaymentMode("upi");
//
//        int generatedId = dao.addOrder(order);
//        System.out.println("✅ Order added successfully. Generated Order ID: " + generatedId);
//
//        // ✅ Test 2: Get all orders for a user
//        ArrayList<Orders> orders = dao.getAllOrders(1);  // replace with same userId
//        System.out.println("\n📦 Orders for userId = 1:");
//        for (Orders o : orders) {
//            System.out.println(o);
//        }
//
//        // ✅ Test 3: Get order by restaurant ID
//        Orders restOrder = dao.specificOrder(101);  // replace with same restaurantId
//        System.out.println("\n🍽️ Specific order from restaurantId = 101:");
//        System.out.println(restOrder);
//    }
//}

