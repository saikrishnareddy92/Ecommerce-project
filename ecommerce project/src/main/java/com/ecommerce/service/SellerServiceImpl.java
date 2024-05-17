package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.DAO.SellerDAO;
import com.ecommerce.model.Seller;
import com.ecommerce.utils.Response;
@Service
public class SellerServiceImpl  implements SellerService{
	@Autowired
	SellerDAO sellerDAO;

	@Override
	public Response addProduct(Seller sellproduct) {
		// TODO Auto-generated method stub
		return sellerDAO.addProduct(sellproduct);
	}

}
