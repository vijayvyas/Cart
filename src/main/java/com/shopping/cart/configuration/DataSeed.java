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
			cartRepository.save(new Cart(1, "Hitachi Ac 1.5 Ton", 1, 10.0, "/item/1", 123));
			cartRepository.save(new Cart(2, "Refregirator 360 Ltr", 2, 20.5, "/item/2", 123));
			cartRepository.save(new Cart(3, "Sony TV 55 Inch", 3, 10.0, "/item/3", 123));
			cartRepository.save(new Cart(4, "Washing Maching 8 ltr", 4, 20.20, "/item/4", 123));
			cartRepository.save(new Cart(5, "Bad King size", 5, 20.0, "/item/5", 123));
			cartRepository.save(new Cart(6, "Sofa 3 by 2", 6, 10.0, "/item/6", 123));
		};
	}
}
