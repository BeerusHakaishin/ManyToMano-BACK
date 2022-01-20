package com.manytomano.api.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private Float price;
	
	private Boolean serviceUsed;

	@OneToMany(mappedBy = "cart")
	private List<CartLine> cartLines; 
	
	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Boolean getServiceUsed() {
		return serviceUsed;
	}

	public void setServiceUsed(Boolean serviceUsed) {
		this.serviceUsed = serviceUsed;
	}

	public Long getId() {
		return this.id;
	}

	public List<CartLine> getCartLines() {
		return cartLines;
	}

	public void setCartLines(List<CartLine> cartLines) {
		this.cartLines = cartLines;
	}
	
}
