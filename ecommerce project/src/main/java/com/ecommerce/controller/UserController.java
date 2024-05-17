package com.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.User;
import com.ecommerce.service.UsersService;
import com.ecommerce.utils.MailSender;
import com.ecommerce.utils.Response;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class UserController {
	@Autowired
	UsersService usersService;
	
	@Operation(summary="this app is working or not",description = "return the product as per the given id")
	
	@RequestMapping("/health")
	public String healthCheck() {
		return "app works fine"; 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody User user) {
		Response response = usersService.registerUser(user);
		if(response.getOperation() == true) {
			MailSender mailSender = new MailSender();
			try {
				int statusCode = mailSender.sendRegistrationConformation(user.getEmail());
				System.out.println("statuscode : " + statusCode);
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		return new ResponseEntity(response,response.getOperation()?HttpStatus.CREATED:HttpStatus.BAD_REQUEST);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/login")
	public ResponseEntity loginUser(@RequestBody User user) {
		Response response = usersService.loginUser(user);
		return new ResponseEntity(response,response.getOperation()?HttpStatus.OK:HttpStatus.BAD_REQUEST);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/users")
	public ResponseEntity getAllUsers() {
		List<User> users = usersService.getUsers();
		return new ResponseEntity(users,HttpStatus.OK);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/forgotpassword")
	public ResponseEntity forgortPassword(@RequestBody User user) {
		Response response = usersService.forgotPassword(user);
		if(response.getOperation() == true) {
			MailSender mailSender = new MailSender();
			try {
				int statusCode = mailSender.forgotPassword(user.getEmail());
				System.out.println("statuscode : " + statusCode);
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		return new ResponseEntity(response,response.getOperation()?HttpStatus.OK:HttpStatus.BAD_REQUEST);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/changepassword")
	public ResponseEntity changePassword(@RequestBody User user) {
		Response response = usersService.changePassword(user);
		return new ResponseEntity(response,response.getOperation()?HttpStatus.OK:HttpStatus.BAD_REQUEST);
	}

}
