package br.com.piel.service.article.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ArticleDto {

	private Long id;

	private String title;

	private String text;
}
