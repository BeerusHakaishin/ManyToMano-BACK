package com.manytomano.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.manytomano.api.entity.Article;
import com.manytomano.api.entity.Category;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	
	// find by category id and on sale	
//	List<Article> findByCategoryAndOnSale(Category category, Boolean onSale);
	
	// find by category id and no shipping fees (seller)	
	@Query(value = "SELECT a FROM article a JOIN seller s ON article.seller_id = seller.id WHERE s.shipping_fees = ?1 AND a.category_id = ?2")
	List<Article> findByShippingFeesAndByCategoryNative(Float shippingFees, Long id);
	
	
	
	// find by category id and on sale and no shipping fees
//	@Query("SELECT ALL FROM article a JOIN seller s ON article.seller_id = seller.id WHERE s.shipping_fees = 0 AND a.category_id = ?1 AND a.on_sale = ?2")
//	List<Article> findByCategoryAndOnSaleAndNoShippingFees(Long id, Boolean onSale);
}