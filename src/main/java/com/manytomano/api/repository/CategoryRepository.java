package com.manytomano.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manytomano.api.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}