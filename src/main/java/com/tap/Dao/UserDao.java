package com.tap.Dao;

import java.util.List;

import com.tap.modeal.*;

public interface UserDao {
	int addUser(User user);

	User getUser(String email);

	void deleteUser(int user);

	void updateUser(User user);

	boolean isValidUser(String Email, String password);

	List<User> getAll();

}
