package com.manytomano.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.manytomano.api.entity.Article;
import com.manytomano.api.entity.Category;
import com.manytomano.api.repository.ArticleRepository;
import com.manytomano.api.repository.CategoryRepository;

@RestController
@CrossOrigin
@RequestMapping("/articles")
public class ArticleController {
	
	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	CategoryRepository categoryRepository;

	// find all
	@GetMapping
	public List<Article> getAll() {
		return articleRepository.findAll();
	}
	
	// find by id
	@GetMapping("/{id}")
	public Article get(@PathVariable(required = true) Long id) {
		Optional<Article> optArticle = articleRepository.findById(id);
		if (optArticle.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return optArticle.get();
	}
	
	// find by category id and on sale	
	@GetMapping("/category/{id}/on-sale")
	public List<Article> findByCategoryAndOnSale(Long id, Boolean onSale) {
		List<Article> articles = categoryRepository.getById(id).getArticles();
		List<Article> articlesOnSale = new ArrayList<>();
		for (Article article : articles) {
			if (article.getOnSale()) {
				articlesOnSale.add(article);
			};
		}		
		return articlesOnSale;
	};
	
	// find by category id and no shipping fees
	
	// find by category id and on sale and no shipping fees
	
}
