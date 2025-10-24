//package com.tap.Test;
////package com.tap.test;
//
//import com.tap.modeal.Menu;
//import com.tap.Dao.MenuDao;
//import com.tap.DaoImple.MenuImp;
//
//import java.util.List;
//
//public class Test3 {
//    public static void main(String[] args) {
//        MenuDao menuDao = new MenuImp();
//
//        // 1. Add a new menu item
//        Menu newMenu = new Menu(
//            0, // ID will be auto-incremented by DB if it's AUTO_INCREMENT
//            "Veg Burger",
//            120.0,
//            "Tasty veg burger with cheese",
//            "images/vegburger.jpg",
//            true,
//            1, // Assuming restaurantId = 1 exists
//            4.3
//        );
//
//        menuDao.addMenu(newMenu);
//
//        // 2. Get menu item by ID
//        Menu fetched = menuDao.getMenu(1); // change to your actual menu ID
//        if (fetched != null) {
//            System.out.println("Fetched: " + fetched.getItemName());
//        } else {
//            System.out.println("Menu not found!");
//        }
//
//        // 3. Update menu item
//        if (fetched != null) {
//            fetched.setItemPrice(130.0);
//            fetched.setRating(4.5);
//            menuDao.updateMenu(fetched);
//        }
//
//        // 4. Get all menu items
//        List<Menu> allMenus = menuDao.getAll();
//        for (Menu m : allMenus) {
//            System.out.println("Menu ID: " + m.getMenuId() + ", Name: " + m.getItemName());
//        }
//
//        // 5. Get all menu items by restaurant
//        List<Menu> byRestaurant = menuDao.getAllMenuByRestarent(1);
//        System.out.println("Menu items from restaurant 1:");
//        for (Menu m : byRestaurant) {
//            System.out.println("- " + m.getItemName());
//        }
//
//        // 6. Delete a menu item (optional test)
//        menuDao.deleteMenu(2); // Change ID accordingly
//    }
//}
