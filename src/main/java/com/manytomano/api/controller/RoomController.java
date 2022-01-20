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

import com.manytomano.api.entity.Room;
import com.manytomano.api.repository.RoomRepository;

@RestController
@CrossOrigin
@RequestMapping("/rooms")
public class RoomController {
	
	@Autowired
	RoomRepository roomRepository;

	// find all
	@GetMapping
	public List<Room> getAll() {
		return roomRepository.findAll();
	}

	// find by id
	@GetMapping("/{id}")
	public Room get(@PathVariable(required = true) Long id) {
		Optional<Room> optRoom = roomRepository.findById(id);
		if (optRoom.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return optRoom.get();
	}
	
}
