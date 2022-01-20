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

import com.manytomano.api.entity.Category;
import com.manytomano.api.repository.CategoryRepository;

@RestController
@CrossOrigin
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryRepository categoryRepository;

	// find all
	@GetMapping
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	// find by id
	@GetMapping("/{id}")
	public Category get(@PathVariable(required = true) Long id) {
		Optional<Category> optCategory = categoryRepository.findById(id);
		if (optCategory.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return optCategory.get();
	}

}
