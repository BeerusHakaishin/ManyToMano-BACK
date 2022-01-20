package com.manytomano.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manytomano.api.entity.CartLine;

public interface CartLineRepository extends JpaRepository<CartLine, Long> {

}