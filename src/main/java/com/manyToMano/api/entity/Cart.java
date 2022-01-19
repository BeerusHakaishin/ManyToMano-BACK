package com.manyToMano.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private Integer price;
	
	private Boolean service_used;

	
	
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Boolean getService_used() {
		return service_used;
	}

	public void setService_used(Boolean service_used) {
		this.service_used = service_used;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
