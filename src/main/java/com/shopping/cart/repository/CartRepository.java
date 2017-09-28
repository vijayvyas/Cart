package com.shopping.cart.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopping.cart.document.Cart;

public interface CartRepository extends MongoRepository<Cart, Integer> {

	
	public Cart findById(Integer itemId);

	public List<Cart> findByUserId(Integer itemId);
}
