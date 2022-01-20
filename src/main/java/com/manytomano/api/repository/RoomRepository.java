package com.manytomano.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manytomano.api.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}