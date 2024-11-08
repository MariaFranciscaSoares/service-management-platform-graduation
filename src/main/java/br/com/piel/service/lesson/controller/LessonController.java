package br.com.piel.service.lesson.controller;

import java.util.ArrayList;
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

import br.com.piel.service.lesson.dto.LessonDto;
import br.com.piel.service.lesson.service.LessonService;

@RestController
@RequestMapping("lesson")
@CrossOrigin
public class LessonController {

	private final LessonService service;

	public LessonController(LessonService service) {
		this.service = service;
	}

	@GetMapping("/all")
	public ResponseEntity<List<LessonDto>> getAllLessons() {
		List<LessonDto> allLessons = service.searchAllLessons();
		return ResponseEntity.status(HttpStatus.OK).body(allLessons);
	}

	@GetMapping("/byId/{id}")
	public ResponseEntity<LessonDto> getLessonById(@PathVariable("id") Long id) {
		LessonDto lesson = service.searchByLesson(id);
		return ResponseEntity.status(HttpStatus.OK).body(lesson);
	}

	@PostMapping("/save")
	public ResponseEntity<LessonDto> saveLesson(@RequestBody LessonDto lesson) {
		LessonDto lessonSave = service.saveLesson(lesson);
		return ResponseEntity.status(HttpStatus.CREATED).body(lessonSave);
	}

	@GetMapping("/byDiscipline/{disciplineId}")
	public ResponseEntity<ArrayList<LessonDto>> getArticlesByDisciplineId(
			@PathVariable("disciplineId") Long disciplineId) {
		ArrayList<LessonDto> articles = service.searchLessonsByDisciplineId(disciplineId);
		return ResponseEntity.status(HttpStatus.OK).body(articles);
	}
}
