package br.com.piel.service.article.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import br.com.piel.service.article.service.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.piel.service.article.dto.ArticleDto;
import br.com.piel.service.article.entity.ArticleEntity;
import br.com.piel.service.article.repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {

	private final ArticleRepository articleRepository;
	private final ModelMapper modelMapper;

	public ArticleServiceImpl(ArticleRepository articleRepository, ModelMapper modelMapper) {
		this.articleRepository = articleRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<ArticleDto> searchAllArticles() {
		List<ArticleEntity> articleEntity = articleRepository.findAll();
		return articleEntity.stream().map(item -> modelMapper.map(item, ArticleDto.class)).collect(Collectors.toList());
	}

	@Override
	public ArticleDto searchByArticle(Long id) {
		ArticleEntity articleEntity = articleRepository.getReferenceById(id);
		return modelMapper.map(articleEntity, ArticleDto.class);
	}

	@Override
	public ArticleDto saveArticle(ArticleDto article) {
		ArticleEntity articleEntity = articleRepository.save(modelMapper.map(article, ArticleEntity.class));
		return modelMapper.map(articleEntity, ArticleDto.class);
	}

}
