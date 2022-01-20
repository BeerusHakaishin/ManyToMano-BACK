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

import com.manytomano.api.entity.Inspiration;
import com.manytomano.api.repository.InspirationRepository;

@RestController
@CrossOrigin
@RequestMapping("/inspirations")
public class InspirationController {
	
	@Autowired
	InspirationRepository inspirationRepository;

	// find all
	@GetMapping
	public List<Inspiration> getAll() {
		return inspirationRepository.findAll();
	}

	// find by id
	@GetMapping("/{id}")
	public Inspiration get(@PathVariable(required = true) Long id) {
		Optional<Inspiration> optInspiration = inspirationRepository.findById(id);
		if (optInspiration.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return optInspiration.get();
	}
	
}
