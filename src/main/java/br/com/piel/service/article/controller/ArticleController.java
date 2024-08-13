package br.com.piel.service.article.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.piel.service.article.dto.ArticleDto;
import br.com.piel.service.article.service.ArticleService;

@RestController
@RequestMapping("article")
@CrossOrigin
public class ArticleController {

    ArticleService service;

    public ArticleController(ArticleService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ArticleDto>> getAllArticles() {
        List<ArticleDto> allArticles = service.searchAllArticles();
        return ResponseEntity.status(HttpStatus.OK).body(allArticles);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<ArticleDto> getArticleById(@PathVariable("id") Long id) {
        ArticleDto article = service.searchByArticle(id);
        return ResponseEntity.status(HttpStatus.OK).body(article);
    }

    @PostMapping("/save")
    public ResponseEntity<ArticleDto> saveArticle(@RequestBody ArticleDto article) {
        ArticleDto articleSave = service.saveArticle(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(articleSave);
    }
}
