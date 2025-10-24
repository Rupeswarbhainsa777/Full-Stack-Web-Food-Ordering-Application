package com.tap.DaoImple;


import com.tap.Dao.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.tap.modeal.History;

public class HistoryDaoImp implements HistoryDao
{   
	private Connection con = null;
//	private PreparedStatement pstmt = null;
	private final String url = "jdbc:mysql://localhost/foodapp";
	private final String username = "root";
	private final String password = "@sumit222";
	private static final   String insert = "INSERT INTO `orderhistory` (`orderHistoryId`, `userId`, `orderId`) VALUES (?, ?, ?)";
	private static final   String  select = "SELECT * FROM orderhistory WHERE `orderHistoryId` = ?";
	private static final String update = "UPDATE orderhistory SET `userId` = ?, `orderId` = ? WHERE `orderHistoryId` = ?";

	private static final   String delete2 = "DELETE FROM `orderhistory` WHERE `orderHistoryId` = ?";
	private static final String selectAll = "SELECT * FROM orderhistory ";
   

    public HistoryDaoImp()
    {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }

    @Override
    public void addOrderHistory(History orderHistory) {
      
        try (
        PreparedStatement stmt = con.prepareStatement(insert))
        {
            stmt.setInt(1, orderHistory.getOrderHistoryId());
            stmt.setInt(2, orderHistory.getUserId());
            stmt.setInt(3, orderHistory.getOrderId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public History getOrderHistory(int orderHistoryId) {
       
        try (PreparedStatement stmt = con.prepareStatement(select)) {
            stmt.setInt(1, orderHistoryId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new History(
                    rs.getInt("orderHistoryId"),
                    rs.getInt("userId"),
                    rs.getInt("orderId")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateOrderHistory(History orderHistory) {
        
        try (PreparedStatement stmt = con.prepareStatement(update)) {
            stmt.setInt(1, orderHistory.getUserId());
            stmt.setInt(2, orderHistory.getOrderId());
            stmt.setInt(3, orderHistory.getOrderHistoryId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderHistory(int orderHistoryId) {
       
        try (PreparedStatement stmt = con.prepareStatement(delete2)) {
            stmt.setInt(1, orderHistoryId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<History> getAll() {
        List<History> list = new ArrayList<>();
       
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(selectAll);
            while (rs.next()) {
                History history = new History(
                    rs.getInt("orderHistoryId"),
                    rs.getInt("userId"),
                    rs.getInt("orderId")
                );
                list.add(history);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
