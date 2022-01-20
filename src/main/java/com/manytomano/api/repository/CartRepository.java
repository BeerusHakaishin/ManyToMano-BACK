package com.manytomano.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manytomano.api.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}