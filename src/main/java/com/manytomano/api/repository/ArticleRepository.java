package com.manytomano.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.manytomano.api.entity.Article;
import com.manytomano.api.entity.Category;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	
	// find by category id and on sale	
	List<Article> findByCategoryAndOnSale(Category category, Boolean onSale);
	
	// find by category id and no shipping fees (seller)	
	@Query("SELECT * FROM article a JOIN seller s ON article.seller_id = seller.id WHERE s.shipping_fees = 0 AND a.category_id = ?1")
	List<Article> findByCategoryAndNoShippingFees(Long id);
	
	// find by category id and on sale and no shipping fees
	@Query("SELECT * FROM article a JOIN seller s ON article.seller_id = seller.id WHERE s.shipping_fees = 0 AND a.category_id = ?1")
	List<Article> findByCategoryAndOnSaleAndNoShippingFees(Long id, Boolean onSale);
}