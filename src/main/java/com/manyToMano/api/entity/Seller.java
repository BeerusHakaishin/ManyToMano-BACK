package com.manyToMano.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Float shipping_fees;
	
	private String logo_url;

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getShipping_fees() {
		return shipping_fees;
	}

	public void setShipping_fees(Float shipping_fees) {
		this.shipping_fees = shipping_fees;
	}

	public String getLogo_url() {
		return logo_url;
	}

	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
