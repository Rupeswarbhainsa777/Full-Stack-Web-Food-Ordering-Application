package com.tap.DaoImple;

import com.tap.modeal.User;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.*;

import com.tap.Dao.UserDao;

public class UserImp implements UserDao {

	private Connection con = null;
	private String url = "jdbc:mysql://localhost/foodapp";
	private String username = "root";
	private String password = "@sumit222";

	String insertQuery = "INSERT INTO `user` ( `name`,`email`,`phoneno`,`address`,`password`,`role`) VALUES (?, ?, ?, ?, ?, ?)";

	String retreiveQuery = "SELECT * FROM `user` WHERE `email` = ?";
	String updateQuery = "UPDATE `user` SET `email` = ?,`address` = ?,`username` = ? , `password` = ? , `role` = ? WHERE `userId` = ?";
	String deleteQuery = "DELETE FROM `user` WHERE `userId` = ?";
	String selectQuery = "Select * FROM `user`";
	String bymail = "SELECT * FROM `user` WHERE `email` = ?";

	final static String SELECTBYUSERANDPASS = "SELECT * from `user` WHERE `email` = ? AND `password` = ?";
	final static String USERNAMEVALID = "SELECT COUNT(*) FROM `user` WHERE `username` = ?";

	PreparedStatement pstm = null;
	Statement stm = null;
	ResultSet res = null;

	public UserImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int addUser(User user) {

		try {
			pstm = con.prepareStatement(insertQuery);

			pstm.setString(1, user.getName());
			pstm.setString(2, user.getEmail());
			pstm.setString(3, user.getPhoneNo());
			pstm.setString(4, user.getAddress());
			pstm.setString(5, user.getPassword());
			pstm.setString(6, user.getRole());

			return pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public User getUser(String email) {
		User user = null;
		try {
			pstm = con.prepareStatement(retreiveQuery);
			pstm.setString(1, email);
			ResultSet res = pstm.executeQuery();
			if (res.next()) {
				user = extractUserFromResultSet(res);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void deleteUser(int user) {
		try {
			pstm = con.prepareStatement(deleteQuery);
			pstm.setInt(1, user);
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateUser(User user) {
		try {
			pstm = con.prepareStatement(updateQuery);
			pstm.setString(1, user.getUserName());
			pstm.setString(2, user.getPassword());
			pstm.setString(3, user.getEmail());
			pstm.setString(4, user.getAddress());
			pstm.setString(5, user.getRole());
			pstm.setInt(6, user.getUserId());
			System.out.println("row affected: " + pstm.executeUpdate());

			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private User extractUserFromResultSet(ResultSet res) throws Exception {
		User user = new User();
		user.setUserName(res.getString("username"));
		user.setPassword(res.getString("password"));
		user.setEmail(res.getString("email"));
		user.setAddress(res.getString("address"));
		user.setRole(res.getString("role"));
		return user;
	}

	@Override
	public List<User> getAll() {
		List<User> list = new ArrayList<>();
		try {
			stm = con.createStatement();
			res = stm.executeQuery(selectQuery);
			while (res.next()) {
				User u = extractUserFromResultSet(res);
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean isUserExists(String userName) {

		boolean exists = false;
		try {
			pstm = con.prepareStatement(USERNAMEVALID);
			pstm.setString(1, userName);

			res = pstm.executeQuery();

			if (res.next()) {
				int c = res.getInt(1);
				exists = c > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exists;
	}
      
	@Override
	public boolean isValidUser(String Email, String password) {
         res=null;
		boolean isValid = false;
		try {
			pstm = con.prepareStatement(SELECTBYUSERANDPASS);

			pstm.setString(1, Email);

			pstm.setString(2, password);

			res = pstm.executeQuery();

			if (res.next()) {
				isValid = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValid;
	}

	public User getUserByEmail(String email) {
		User user = null;

		try {

			pstm = con.prepareStatement(bymail);

			pstm.setString(1, email);
			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				// Set other fields as needed
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

}
