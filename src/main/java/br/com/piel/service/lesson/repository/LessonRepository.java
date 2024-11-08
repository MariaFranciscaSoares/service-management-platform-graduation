package br.com.piel.service.lesson.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.piel.service.lesson.entity.LessonEntity;

public interface LessonRepository extends JpaRepository<LessonEntity, Long> {


	@Query(value = "SELECT * FROM lesson_entity l WHERE l.discipline_id = :disciplineId", nativeQuery = true)
	ArrayList<LessonEntity> findByDisciplineId(@Param("disciplineId") Long disciplineId);
}
