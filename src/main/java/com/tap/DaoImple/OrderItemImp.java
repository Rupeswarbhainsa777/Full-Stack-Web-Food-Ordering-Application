package com.tap.DaoImple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import com.tap.Dao.OrderItemDao;
import com.tap.modeal.OrderItem;

public class OrderItemImp implements OrderItemDao {

	private Connection con = null;
	private PreparedStatement pstmt = null;
	
	private final String url = "jdbc:mysql://localhost/foodapp";
	private final String username = "root";
	private final String password = "@sumit222";

	private static final String insert = "insert into `orderItem`(`userId`,`menueId`,`quantity`,`price`,) values(?,?,?,?)";
	private static final String select = "select * from `orderItem` where orderItemId=?";
	private static final String selectAll = "select * from `orderItem`";
	private static final String update = "UPDATE `orderItem` SET `userId`=?, `menueId`=?,  `quantity`=?, `price`=? WHERE `orderItemId`=?";


	private static final String delete = "DELETE FROM `orderItem` WHERE `orderItemId`=?";

	final static String SELECTAllUSERID = "SELECT * FROM `orderItem` Where `userId`=?";

	public OrderItemImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void addOrderItem(OrderItem orderItem) {

		try {
			 PreparedStatement pstmt= con.prepareStatement(insert); 
			
			pstmt.setInt(1, orderItem.getOrderItemId());
			pstmt.setInt(2, orderItem.getUserId());
			pstmt.setInt(3, orderItem.getMenuId());
			pstmt.setInt(4, orderItem.getQuantity());
			
			pstmt.setDouble(5, orderItem.getPrice());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}

	}
	
	@Override
    public OrderItem getOrderItem(int id) 
	{
        try (
        	 PreparedStatement pstmt= con.prepareStatement(select)) 
        {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new OrderItem(
               
                    rs.getInt("userId"),
                    rs.getInt("menueId"),
               
                    rs.getInt("quantity"),
                    rs.getDouble("price")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

	
	
	
	@Override
    public void updateOrderItem(OrderItem item)
	{
       
        try (PreparedStatement pstmt = con.prepareStatement(update)) {
            pstmt.setInt(1, item.getUserId());
            pstmt.setInt(2, item.getMenuId());
           
            pstmt.setInt(3, item.getQuantity());
        
            pstmt.setDouble(4, item.getPrice());
            pstmt.setInt(5, item.getOrderItemId());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	
	@Override
    public void deleteOrderItem(int id) {
       
        try (PreparedStatement pstmt = con.prepareStatement(delete)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	
	@Override
    public List<OrderItem> getAll() {
        List<OrderItem> list = new ArrayList<>();
      
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(selectAll)) {

            while (rs.next()) {
                OrderItem item = new OrderItem(
                 
                    rs.getInt("user_id"),
                    rs.getInt("menu_id"),
                   
                    rs.getInt("quantity"),
               
                    rs.getDouble("price")
                );
                list.add(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	
	
	

}
