package com.tap.DaoImple;

import com.tap.Dao.ResturantDao;
import com.tap.modeal.Restaurant;

import java.sql.*;
import java.util.ArrayList;

public class RestaurantImp implements ResturantDao {

    private Connection con;
    private final String url = "jdbc:mysql://localhost:3306/foodapp";
    private final String username = "root";
    private final String password = "@sumit222";

    public RestaurantImp() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String ADD_RESTAURANT = "INSERT INTO resturent1 (restaurantName, imagePath, rating, eta, cuisineType, address, isActive, restaurantOwnerId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_RESTAURANT = "SELECT * FROM resturent1";
    private static final String SELECT_RESTAURANT = "SELECT * FROM resturent1 WHERE restaurant_id = ?";
    private static final String UPDATE_RESTAURANT = "UPDATE restaurant1 SET restaurantName = ?, imagePath = ?, rating = ?, eta = ?, cuisineType = ?, address = ?, isActive = ?, restaurantOwnerId = ? WHERE restaurant_id = ?";
    private static final String DELETE_RESTAURANT = "DELETE FROM resturent1 WHERE restaurant_id = ?";

    @Override
    public void addRestaurant(Restaurant restaurant) {
        try (PreparedStatement pstmt = con.prepareStatement(ADD_RESTAURANT)) {
            pstmt.setString(1, restaurant.getName());
            pstmt.setString(2, restaurant.getImagepath());
            pstmt.setInt(3, restaurant.getRating());
            pstmt.setString(4, restaurant.getEta());
            pstmt.setString(5, restaurant.getCuisineType());
            pstmt.setString(6, restaurant.getAddress());
            pstmt.setBoolean(7, restaurant.getIsActive());
            pstmt.setString(8, restaurant.getRestaurantOwnerId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Restaurant getRestaurant(int restaurantId) {
        Restaurant restaurant = null;
        try (PreparedStatement pstmt = con.prepareStatement(SELECT_RESTAURANT)) {
            pstmt.setInt(1, restaurantId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                restaurant = mapResultSetToRestaurant(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        try (PreparedStatement pstmt = con.prepareStatement(UPDATE_RESTAURANT)) {
            pstmt.setString(1, restaurant.getName());
            pstmt.setString(2, restaurant.getImagepath());
            pstmt.setInt(3, restaurant.getRating());
            pstmt.setString(4, restaurant.getEta());
            pstmt.setString(5, restaurant.getCuisineType());
            pstmt.setString(6, restaurant.getAddress());
            pstmt.setBoolean(7, restaurant.getIsActive());
            pstmt.setString(8, restaurant.getRestaurantOwnerId());
            pstmt.setInt(9, restaurant.getRestaurantId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRestaurant(int restaurantId) {
        try (PreparedStatement pstmt = con.prepareStatement(DELETE_RESTAURANT)) {
            pstmt.setInt(1, restaurantId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Restaurant> getAllRestaurant() {
        ArrayList<Restaurant> list = new ArrayList<>();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_RESTAURANT)) {
            while (rs.next()) {
                list.add(mapResultSetToRestaurant(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Restaurant mapResultSetToRestaurant(ResultSet rs) throws SQLException {
        int id = rs.getInt("restaurant_id");
        String name = rs.getString("restaurantName");
        String imagePath = rs.getString("imagePath");
        int rating = rs.getInt("rating");
        String eta = rs.getString("eta");
        String cuisineType = rs.getString("cuisineType");
        String address = rs.getString("address");
        boolean isActive = rs.getBoolean("isActive");
        String restaurantOwnerId = rs.getString("restaurantOwnerId");

        return new Restaurant(id, name, imagePath, rating, eta, cuisineType, address, isActive, restaurantOwnerId);
    }
}
