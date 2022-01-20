package com.manytomano.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manytomano.api.entity.Inspiration;

public interface InspirationRepository extends JpaRepository<Inspiration, Long> {

}