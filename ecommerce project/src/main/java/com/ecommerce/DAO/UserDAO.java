package com.ecommerce.DAO;

import java.util.List;

import com.ecommerce.model.User;
import com.ecommerce.utils.Response;

//this interface is the contract between userdao and userdaoimpl

public interface UserDAO {
	public Response registerUser(User user);
	public Response loginUser(User user);
	public List<User> getUsers();
	public Response forgotPassword(User user);
	public Response changePassword(User user);
	

}
