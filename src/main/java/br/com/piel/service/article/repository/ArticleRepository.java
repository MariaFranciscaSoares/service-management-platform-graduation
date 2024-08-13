package br.com.piel.service.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.piel.service.article.entity.ArticleEntity;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

}
