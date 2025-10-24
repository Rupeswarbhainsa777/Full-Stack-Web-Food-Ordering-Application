//package com.tap.Test;
//
//
//import com.tap.DaoImple.HistoryDaoImp;
//import com.tap.modeal.History;
//import java.util.List;
//
//public class Testin6 {
//    public static void main(String[] args) {
//        HistoryDaoImp historyDao = new HistoryDaoImp();
//
//        // 🔹 Insert sample data
//        History h1 = new History(1, 101, 1001);
//        History h2 = new History(2, 102, 1002);
//        History h3 = new History(3, 103, 1003);
//
//        historyDao.addOrderHistory(h1);
//        historyDao.addOrderHistory(h2);
//        historyDao.addOrderHistory(h3);
//
//        System.out.println("✅ Sample data inserted.");
//
//        // 🔹 Get one history
//        History fetched = historyDao.getOrderHistory(2);
//        if (fetched != null) {
//            System.out.println("📦 Fetched OrderHistory: ID = " + fetched.getOrderHistoryId() +
//                               ", UserID = " + fetched.getUserId() +
//                               ", OrderID = " + fetched.getOrderId());
//        }
//
//        // 🔹 Update history
//        h2.setOrderId(9999);
//        historyDao.updateOrderHistory(h2);
//        System.out.println("🔄 Updated OrderID for OrderHistory ID 2 to 9999.");
//
//        // 🔹 List all histories
//        List<History> list = historyDao.getAll();
//        System.out.println("📋 All Order Histories:");
//        for (History h : list) {
//            System.out.println("ID: " + h.getOrderHistoryId() +
//                               ", UserID: " + h.getUserId() +
//                               ", OrderID: " + h.getOrderId());
//        }
//
//        // 🔹 Delete one history
//        historyDao.deleteOrderHistory(3);
//        System.out.println("❌ Deleted OrderHistory with ID 3.");
//    }
//}
