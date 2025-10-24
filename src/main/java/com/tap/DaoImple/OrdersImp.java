package com.tap.DaoImple;

import java.sql.*;
import java.util.ArrayList;
import com.tap.modeal.Orders;
import com.tap.Dao.OrderDao;


public class OrdersImp implements OrderDao {
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet resultSet;
	 private final String url = "jdbc:mysql://localhost/foodapp";
	    private final String username = "root";
	    private final String password = "@sumit222";

	private static final String ADD_ORDER = "INSERT INTO `order` (`userId`, `restaurantId`, `totalAmount`, `status`, `modeOfPayment`) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM `order` WHERE `userId` = ?";
    private static final String SELECT_BY_RESTAURANTID = "SELECT * FROM `order` WHERE `restaurantId` = ?";
    
    
   
	 public OrdersImp() {
		
		
		try {
			
			 Class.forName("com.mysql.cj.jdbc.Driver");

	         System.out.println("Driver loaded");
	         con = DriverManager.getConnection(url, username, password);
	         System.out.println("Connection established");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	 @Override
	 public int addOrder(Orders ot) {
	     int generatedOrderId = 0;
	     try {
	         pstmt = con.prepareStatement(ADD_ORDER, Statement.RETURN_GENERATED_KEYS);
	         pstmt.setInt(1, ot.getUserId());
	         pstmt.setInt(2, ot.getRestaurantId());
	         pstmt.setDouble(3, ot.getTotalAmount());
	         pstmt.setString(4, ot.getStatus());
	         pstmt.setString(5, ot.getPaymentMode());

	         int status = pstmt.executeUpdate(); // EXECUTE the INSERT

	         if (status > 0) {
	             ResultSet res = pstmt.getGeneratedKeys();
	             if (res.next()) {
	                 generatedOrderId = res.getInt(1);
	             }
	         }

	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	     return generatedOrderId;
	 }

	@Override
	public ArrayList<Orders> getAllOrders(int userId) {
		ArrayList<Orders> orderTableList = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(SELECT_ALL);
			pstmt.setInt(1, userId);
			resultSet = pstmt.executeQuery();

			orderTableList = extractOrderTableFromResultSet(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderTableList;
	}

	@Override
	public Orders specificOrder(int restaurantId) {
		Orders ordertable = null;
		try {
			pstmt = con.prepareStatement(SELECT_BY_RESTAURANTID);
			pstmt.setInt(1, restaurantId);

			resultSet = pstmt.executeQuery();
			ArrayList<Orders> orderTableList = extractOrderTableFromResultSet(resultSet);

			if (!orderTableList.isEmpty()) {
				ordertable = orderTableList.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordertable;
	}

	private ArrayList<Orders> extractOrderTableFromResultSet(ResultSet resultSet) {
		ArrayList<Orders> list = new ArrayList<>();
		try {
			while (resultSet.next()) {
				list.add(new Orders(
					resultSet.getInt("orderId"),
					resultSet.getInt("userId"),
					resultSet.getInt("restaurantId"),
					resultSet.getTimestamp("orderDate"),
					resultSet.getDouble("totalAmount"),
					resultSet.getString("status"),
					resultSet.getString("modeOfPayment")
				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
