package br.com.piel.service.lesson.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.piel.service.lesson.dto.LessonDto;
import br.com.piel.service.lesson.entity.LessonEntity;
import br.com.piel.service.lesson.repository.LessonRepository;
import br.com.piel.service.lesson.service.LessonService;

@Service
public class LessonServiceImpl implements LessonService {

	private final LessonRepository lessonRepository;
	private final ModelMapper modelMapper;

	public LessonServiceImpl(LessonRepository lessonRepository, ModelMapper modelMapper) {
		this.lessonRepository = lessonRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<LessonDto> searchAllLessons() {
		List<LessonEntity> lessonEntities = lessonRepository.findAll();
		return lessonEntities.stream().map(item -> modelMapper.map(item, LessonDto.class)).collect(Collectors.toList());
	}

	@Override
	public LessonDto searchByLesson(Long id) {
		LessonEntity lessonEntity = lessonRepository.getReferenceById(id);
		return modelMapper.map(lessonEntity, LessonDto.class);
	}

	@Override
	public LessonDto saveLesson(LessonDto lesson) {
		LessonEntity lessonEntity = lessonRepository.save(modelMapper.map(lesson, LessonEntity.class));
		return modelMapper.map(lessonEntity, LessonDto.class);
	}

	@Override
	public ArrayList<LessonDto> searchLessonsByDisciplineId(Long disciplineId) {
		ArrayList<LessonEntity> lessons = lessonRepository.findByDisciplineId(disciplineId);
		return lessons.stream().map(lesson -> modelMapper.map(lesson, LessonDto.class))
				.collect(Collectors.toCollection(ArrayList::new));
	}

}
