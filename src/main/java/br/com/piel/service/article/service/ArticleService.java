package br.com.piel.service.article.service;

import java.util.List;

import br.com.piel.service.article.dto.ArticleDto;

public interface ArticleService {

	List<ArticleDto> searchAllArticles();

	ArticleDto searchByArticle(Long id);
	
	ArticleDto saveArticle(ArticleDto article);
}
