package com.manytomano.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.manytomano.api.dto.CartLineDto;
import com.manytomano.api.entity.CartLine;
import com.manytomano.api.repository.CartLineRepository;

@RestController
@CrossOrigin
@RequestMapping("/cartlines")
public class CartLineController {
	
	@Autowired	
	CartLineRepository cartLineRepository;

	// find all
	@GetMapping
	public List<CartLine> getAll() {
		return cartLineRepository.findAll();
	}

	// find by id
	@GetMapping("/{id}")
	public CartLine get(@PathVariable(required = true) Long id) {
		Optional<CartLine> optCartLine = cartLineRepository.findById(id);
		if (optCartLine.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return optCartLine.get();
	}
	
	// create 
		@PostMapping
		public CartLine create(@Valid @RequestBody CartLineDto cartLineDto) {
			CartLine cartLine = new CartLine();
			cartLine.setQuantity(cartLineDto.getQuantity());
			cartLine.setTotalPrice(cartLineDto.getTotalPrice());

			return cartLineRepository.save(cartLine);
		}

		// update by id
		@PutMapping("/{id}")
		public CartLine update(@PathVariable(required = true) Long id, @Valid @RequestBody CartLineDto cartLineDto) {
			Optional<CartLine> optCartLine = cartLineRepository.findById(id);
			if(optCartLine.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
			
			CartLine cartLine = optCartLine.get();
			cartLine.setQuantity(cartLineDto.getQuantity());
			cartLine.setTotalPrice(cartLineDto.getTotalPrice());

			return cartLineRepository.save(cartLine);
		}
		
		// delete by id
		@DeleteMapping("/{id}")
		public void delete(@PathVariable(required = true) Long id) {
			Optional<CartLine> optCartLine = cartLineRepository.findById(id);
			if(optCartLine.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
			cartLineRepository.deleteById(id);
		}
	
}
