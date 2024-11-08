package br.com.piel.service.lesson.service;

import java.util.ArrayList;
import java.util.List;

import br.com.piel.service.lesson.dto.LessonDto;

public interface LessonService {

	List<LessonDto> searchAllLessons();

	LessonDto searchByLesson(Long id);

	LessonDto saveLesson(LessonDto lesson);

	ArrayList<LessonDto> searchLessonsByDisciplineId(Long disciplineId);

}
