package com.shopping.cart.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.shopping.cart.document.Cart;
import com.shopping.cart.repository.CartRepository;

@EnableMongoRepositories(basePackageClasses = CartRepository.class )
@Configuration
public class DataSeed {

	@Bean
	CommandLineRunner init(CartRepository cartRepository) {
		return (evt) -> {
			cartRepository.save(new Cart(1, "Item1", 1, 10.0, "/item/1", 123));
			cartRepository.save(new Cart(2, "Item2", 2, 20.0, "/item/2", 123));
		};
	}
}
