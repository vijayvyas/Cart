package com.shopping.cart.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.cart.document.Cart;
import com.shopping.cart.repository.CartRepository;

@RestController
@RequestMapping("/{userId}/cart")
public class CartController {
	
	CartRepository cartRepository;

	public CartController(CartRepository cartRepository) {
		super();
		this.cartRepository = cartRepository;
	}



	@GetMapping()
	public List<Cart> getAll(@PathVariable Integer userId)
	{
		return cartRepository.findByUserId(userId);
	}
	
	
	@PostMapping()
	public @ResponseBody ResponseEntity<Cart> addItem(@PathVariable Integer userId, @RequestBody Cart item)
	{
		item.setUserId(userId);
		if (null != cartRepository.findById(item.getId())) {
	            System.out.println("A Item with name " + item.getItemName() + " already exist");
	            
	            return new ResponseEntity<Cart>(cartRepository.save(item), HttpStatus.OK);
	    }
		
		return new ResponseEntity<Cart>(cartRepository.insert(item), HttpStatus.CREATED);
	}
	
	@PutMapping()
	public @ResponseBody ResponseEntity<List<Cart>> updateCart(@PathVariable String userId, @RequestBody List<Cart> cart)
	{
		return new ResponseEntity<List<Cart>>(cartRepository.save(cart), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{itemId}")
	public @ResponseBody ResponseEntity<Void> removeItem(@PathVariable Integer userId, @PathVariable Integer itemId)
	{
		cartRepository.delete(itemId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
