package br.com.piel.service.activity.service;

import java.util.List;

import br.com.piel.service.activity.dto.ActivityDto;

public interface ActivityService {

	List<ActivityDto> searchAllActivities();

	ActivityDto searchByActivity(Long id);

	ActivityDto saveActivity(ActivityDto activity);

	void completeActivity(Long id);

	List<ActivityDto> searchArticlesByDisciplineId(Long disciplineId);

}
