package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.DAO.UserDAO;
import com.ecommerce.model.User;
import com.ecommerce.utils.Response;

public class UsersServiceImpl  implements UsersService{
	
	@Autowired
	UserDAO usersDAO;
	@Override
	public Response registerUser(User user) {
		return usersDAO.registerUser(user);
	}
	@Override
	public Response loginUser(User user) {
		return usersDAO.loginUser(user);
	}
	@Override
	public List<User> getUsers() {
		return usersDAO.getUsers();
	}
	@Override
	public Response forgotPassword(User user) {
		return usersDAO.forgotPassword(user);
	}
	@Override
	public Response changePassword(User user) {
		return usersDAO.changePassword(user);
	}
	

}
