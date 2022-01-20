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

import com.manytomano.api.entity.Seller;
import com.manytomano.api.repository.SellerRepository;

@RestController
@CrossOrigin
@RequestMapping("/sellers")
public class SellerController {
	
	@Autowired
	SellerRepository sellerRepository;

	// find all
	@GetMapping
	public List<Seller> getAll() {
		return sellerRepository.findAll();
	}

	// find by id
	@GetMapping("/{id}")
	public Seller get(@PathVariable(required = true) Long id) {
		Optional<Seller> optSeller = sellerRepository.findById(id);
		if (optSeller.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return optSeller.get();
	}
	
}
