package br.com.piel.service.activity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.piel.service.activity.entity.ActivityEntity;
import br.com.piel.service.article.entity.ArticleEntity;
import jakarta.transaction.Transactional;

public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {

	@Transactional
	@Modifying
	@Query("UPDATE ActivityEntity a SET a.status = 'concluida' WHERE a.id = :id")
	void completeActivity(Long id);

	@Query(value = "SELECT * FROM activity_entity a WHERE a.discipline_id = :disciplineId", nativeQuery = true)
	List<ActivityEntity> findByDisciplineId(@Param("disciplineId") Long disciplineId);

}
