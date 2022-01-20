package com.manytomano.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.manytomano.api.entity.Cart;
import com.manytomano.api.repository.CartRepository;

@RestController
@CrossOrigin
@RequestMapping("/carts")
public class CartController {
	
	@Autowired
	CartRepository cartRepository;

	// find all
	@GetMapping
	public List<Cart> getAll() {
		return cartRepository.findAll();
	}

	// find by id
	@GetMapping("/{id}")
	public Cart get(@PathVariable(required = true) Long id) {
		Optional<Cart> optCart = cartRepository.findById(id);
		if (optCart.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return optCart.get();
	}
	
}
