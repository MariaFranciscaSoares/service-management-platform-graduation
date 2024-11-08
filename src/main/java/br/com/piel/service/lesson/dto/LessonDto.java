package br.com.piel.service.lesson.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessonDto {

	private Long id;

	private String title;

	private String status;

	private String videoUrl;

	private List<String> topics; 
}
