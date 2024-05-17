package com.ecommerce.DAO;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.User;
import com.ecommerce.utils.Response;

import jakarta.persistence.Query;

@Repository
public class UserDAOImpl  implements UserDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("deprecation")
	@Override
	public Response registerUser(User user) {
		Response response = new Response();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		int i = (int)session.save(user);
		if(i!=0) {
			response.setMessage("Registration success");
			response.setOperation(true);
			response.setStatusCode(200);
		}
		else {
			response.setMessage(" Registration failed");
			response.setOperation(false);
			response.setStatusCode(500);
		}
		tx.commit();
		return response;
	}
	

	@SuppressWarnings({ "deprecation", "rawtypes", "unused" })
	@Override
	public Response loginUser(User user) {
		Response response = new Response();
		
		System.out.println("Iam in UserDAOImpl");
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "select user.password from User user where user.email = :email";
		Query query = session.createQuery(hql);
		query.setParameter("email" , user.getEmail() );
		List result = ((org.hibernate.query.Query) query).list();
		System.out.println("resultset : " + result);
		System.out.println(result.isEmpty());
		if(result.isEmpty()) {
			response.setMessage("User not found");
			response.setOperation(false);
			response.setStatusCode(404);
			
		}else {
			Iterator iterator = result.iterator();
			while(iterator.hasNext()) {
				String password = (String)iterator.next();
				System.out.println("Password from db : " + password);
				if(password.contentEquals(user.getPassword())) {
					response.setMessage("Login success");
					response.setOperation(true);
					response.setStatusCode(200);
					
				}else {
					response.setMessage("Incorrect password");
					response.setOperation(true);
					response.setStatusCode(401);
				}
			}
		}
		
		return response;
	}

	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	@Override
	public List<User> getUsers() {
		Session session = sessionFactory.openSession();
		String hql = "from User users";
		Query query = session.createQuery(hql);
		List result = ((org.hibernate.query.Query) query).list();
	return result;
	}
	

	@SuppressWarnings({ "deprecation", "rawtypes", "unused" })
	@Override
	public Response forgotPassword(User user) {
		Response response = new Response();
		System.out.println(user.getEmail());
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "select user.password from User user where user.email = :email";
		Query query = session.createQuery(hql);
		query.setParameter("email" , user.getEmail() );
		List result = ((org.hibernate.query.Query) query).list();
		System.out.println("resultset : " + result);
		if(result.isEmpty()) {
			response.setMessage("User not found");
			response.setOperation(false);
			response.setStatusCode(404);
			
		}else {
			response.setMessage("Email sent");
			response.setOperation(true);
			response.setStatusCode(200);
			
		}
		
		return response;
	}


	@SuppressWarnings({ "deprecation" })
	@Override
	public Response changePassword(User user) {
		Response response = new Response();
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "Update User user set user.password = :password where user.email = :email";
		Query query = session.createQuery(hql);
		query.setParameter("email" , user.getEmail() );
		query.setParameter("email" , user.getPassword());
		int count = query.executeUpdate();
		tx.commit();
		System.out.println("count: "+count);
		
		if(count>0) {
			response.setMessage("password changed successfully");
			response.setOperation(true);
			response.setStatusCode(200);
			
		}else {
			response.setMessage("password changing failed!!");
			response.setOperation(false);
			response.setStatusCode(200);
			
		}
	
		return response;
	}

}
