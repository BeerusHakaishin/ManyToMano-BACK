package com.manytomano.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manytomano.api.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}