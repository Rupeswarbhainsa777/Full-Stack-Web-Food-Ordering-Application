//package com.tap.Test;
//
//import com.tap.Dao.OrderItemDao;
//import com.tap.DaoImple.OrderItemImp;
//import com.tap.modeal.OrderItem;
//
//import java.util.List;
//
//public class Test5 {
//    public static void main(String[] args) {
//    	OrderItemImp dao = new OrderItemImp();
//
//        // 1. Add an OrderItem
//        OrderItem item = new OrderItem();
//        item.setOrderItemId(1);
//        item.setUserId(1001);
//        item.setMenuId(2001);
//        item.setName("Veg Biryani");
//        item.setQuantity("2");
//        item.setRating(4.5);
//        item.setPrice(250.00);
//
//  
//        System.out.println("OrderItem Added!");
//
//        // 2. Fetch the inserted item
//        OrderItem fetched = dao.getOrderItem(1);
//        if (fetched != null) {
//            System.out.println("Fetched OrderItem: " + fetched.getName() + " - " + fetched.getPrice());
//        } else {
//            System.out.println("OrderItem not found!");
//        }
//
//        // 3. Update the OrderItem
//        fetched.setName("Paneer Biryani");
//        fetched.setPrice(275.0);
//    
//        System.out.println("OrderItem Updated!");
//
//        // 4. Get All Items
//        List<OrderItem> allItems = dao.getAll();
//        System.out.println("All Order Items:");
//        for (OrderItem oi : allItems) {
//            System.out.println(oi.getOrderItemId() + ": " + oi.getName() + " - " + oi.getPrice());
//        }
//
//        // 5. Delete the OrderItem
// 
//        System.out.println("OrderItem Deleted!");
//    }
//}
