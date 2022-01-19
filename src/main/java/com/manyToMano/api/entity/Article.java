package com.manyToMano.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String name;
	
	private Float price;
	
	private Boolean on_sale;
	
	private String image_url;
	
	private String details_image_url;
	
	private Integer evaluation;

	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Boolean getOn_sale() {
		return on_sale;
	}

	public void setOn_sale(Boolean on_sale) {
		this.on_sale = on_sale;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getDetails_image_url() {
		return details_image_url;
	}

	public void setDetails_image_url(String details_image_url) {
		this.details_image_url = details_image_url;
	}

	public Integer getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Integer evaluation) {
		this.evaluation = evaluation;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
