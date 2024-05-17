package com.ecommerce.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Product;
import com.ecommerce.utils.Response;
@Repository
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Response addProduct(Product product) {
		Response response = new Response();
		Session session =  sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		 @SuppressWarnings("deprecation")
		int  i =(int) session.save(product);
		 if(i!=0) {
			 response.setMessage("product added successfully");
			 response.setOperation(true);
			 response.setStatusCode(201);
		 }
		 else {
			 response.setMessage(" adding product failed");
			 response.setOperation(false);
			 response.setStatusCode(500);
			 }
		 tx.commit();
		return response;
		
	}

}
