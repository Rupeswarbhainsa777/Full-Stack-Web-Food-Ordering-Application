package com.tap.DaoImple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.Dishdao;
import com.tap.modeal.Dish;
import com.tap.modeal.Restaurant;

public class DishDAOImp implements Dishdao {

	private final String url = "jdbc:mysql://localhost:3306/foodapp";
	private final String username = "root";
	private final String password = "@sumit222";
	private final String sql = "SELECT * FROM `dish` WHERE `id` = 1";
	private final String selectAll = "SELECT * FROM `dish`";
    String insertQuery = "INSERT INTO `dish` (`name`, `description`, `imagepath`) VALUES (?, ?, ?)";


	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection con = null;

	public DishDAOImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Dish> getAllDishes() {
	    List<Dish> list = new ArrayList<>();
	

	    try (Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery(selectAll)) {

	        while (rs.next()) {
	            Dish dish = mapAllDish(rs);
	            if (dish != null) {
	                list.add(dish);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}


	private Dish mapAllDish(ResultSet re) {
	    try {
	       
	        String name = re.getString("name");
	        String des = re.getString("description");
	        String imagePath = re.getString("imagepath");
	      
	        
	        
	        return new Dish(name, des, imagePath);
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null; // Optional: return null to indicate failure
	    }
	}


	@Override
	public Dish getSpecialDish() {
		Dish dish = null;

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				dish = new Dish();
				dish.setId(rs.getInt("id"));
				dish.setName(rs.getString("name"));
				dish.setDescription(rs.getString("description"));
				dish.setImagePath(rs.getString("imagepath"));
			
			}

		} catch (Exception e) {
			
		}

		return dish;
	}
	public boolean addDish(Dish dish) {

	    try (
	    PreparedStatement ps = con.prepareStatement(insertQuery)) {
	        ps.setString(1, dish.getName());
	        ps.setString(2, dish.getDescription());
	        ps.setString(3, dish.getImagePath());
	      

	        int rows = ps.executeUpdate();
	        return rows > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}
