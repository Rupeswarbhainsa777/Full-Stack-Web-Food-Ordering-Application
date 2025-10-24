package com.tap.DaoImple;

import com.tap.modeal.Menu;
import com.tap.Dao.MenuDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuImp implements MenuDao {
    private final String url = "jdbc:mysql://localhost/foodapp";
    private final String username = "root";
    private final String password = "@sumit222";

    private static final String ADD_MENU = "INSERT INTO `menu` (`itemname`, `itemprice`, `description`, `imagepath`, `isAvailable`, `rating`, `restaurantId`) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ONE = "SELECT * FROM `menu` WHERE `menuid` = ?";
    private static final String UPDATE = "UPDATE `menu` SET `itemname` = ?, `description` = ?, `itemprice` = ?, `imagepath` = ?, `isAvailable` = ?, `rating` = ?, `restaurantId` = ? WHERE `menuid` = ?";
    private static final String DELETE = "DELETE FROM `menu` WHERE `menuid` = ?";
    private static final String SELECT_REST_ID = "SELECT * FROM `menu` WHERE `restaurantId` = ?";
    private static final String SELECT_ALL = "SELECT * FROM `menu`";

    private Connection connection;

    public MenuImp() {
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver loaded");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addMenu(Menu menu) {
        try (PreparedStatement pstmt = connection.prepareStatement(ADD_MENU)) {
            pstmt.setString(1, menu.getItemName());
            pstmt.setDouble(2, menu.getItemPrice());
            pstmt.setString(3, menu.getDescription());
            pstmt.setString(4, menu.getImagePath());
            pstmt.setBoolean(5, menu.isAvailable());
            pstmt.setDouble(6, menu.getRating());
            pstmt.setInt(7, menu.getRestaurantId());

            System.out.println(pstmt.executeUpdate() + " row(s) inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Menu getMenu(int menuId) {
        Menu menu = null;
        try (PreparedStatement pstmt = connection.prepareStatement(SELECT_ONE)) {
            pstmt.setInt(1, menuId);
            try (ResultSet rest = pstmt.executeQuery()) {
                if (rest.next()) {
                    menu = new Menu(
                        menuId,
                        rest.getString("itemname"),
                        rest.getDouble("itemprice"),
                        rest.getString("description"),
                        rest.getString("imagepath"),
                        rest.getBoolean("isAvailable"),
                        rest.getInt("restaurantId"),
                        rest.getDouble("rating")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

    @Override
    public void updateMenu(Menu menu) {
        try (PreparedStatement pstmt = connection.prepareStatement(UPDATE)) {
            pstmt.setString(1, menu.getItemName());
            pstmt.setString(2, menu.getDescription());
            pstmt.setDouble(3, menu.getItemPrice());
            pstmt.setString(4, menu.getImagePath());
            pstmt.setBoolean(5, menu.isAvailable());
            pstmt.setDouble(6, menu.getRating());
            pstmt.setInt(7, menu.getRestaurantId());
            pstmt.setInt(8, menu.getMenuId());

            System.out.println(pstmt.executeUpdate() + " row(s) updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMenu(int menuId) {
        try (PreparedStatement pstmt = connection.prepareStatement(DELETE)) {
            pstmt.setInt(1, menuId);
            System.out.println(pstmt.executeUpdate() + " row(s) deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Menu> getAllMenuByRestarent(int restaurantId) {
        List<Menu> menuList = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(SELECT_REST_ID)) {
            pstmt.setInt(1, restaurantId);
            try (ResultSet rest = pstmt.executeQuery()) {
                while (rest.next()) {
                    Menu menu = new Menu(
                        rest.getInt("menuid"),
                        rest.getString("itemname"),
                        rest.getDouble("itemprice"),
                        rest.getString("description"),
                        rest.getString("imagepath"),
                        rest.getBoolean("isAvailable"),
                        restaurantId,
                        rest.getDouble("rating")
                    );
                    menuList.add(menu);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }

    @Override
    public List<Menu> getAll() {
        List<Menu> menuList = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rest = stmt.executeQuery(SELECT_ALL)) {
            while (rest.next()) {
                Menu menu = new Menu(
                    rest.getInt("menuid"),
                    rest.getString("itemname"),
                    rest.getDouble("itemprice"),
                    rest.getString("description"),
                    rest.getString("imagepath"),
                    rest.getBoolean("isAvailable"),
                    rest.getInt("restaurantId"),
                    rest.getDouble("rating")
                );
                menuList.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }
}
