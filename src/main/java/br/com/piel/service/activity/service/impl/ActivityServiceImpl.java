package br.com.piel.service.activity.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.piel.service.activity.dto.ActivityDto;
import br.com.piel.service.activity.entity.ActivityEntity;
import br.com.piel.service.activity.repository.ActivityRepository;
import br.com.piel.service.activity.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

	private final ActivityRepository activityRepository;
	private final ModelMapper modelMapper;

	public ActivityServiceImpl(ActivityRepository activityRepository, ModelMapper modelMapper) {
		this.activityRepository = activityRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<ActivityDto> searchAllActivities() {
		List<ActivityEntity> activityEntities = activityRepository.findAll();
		return activityEntities.stream().map(activity -> modelMapper.map(activity, ActivityDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ActivityDto searchByActivity(Long id) {
		ActivityEntity activityEntity = activityRepository.getReferenceById(id);
		return modelMapper.map(activityEntity, ActivityDto.class);
	}

	@Override
	public ActivityDto saveActivity(ActivityDto activity) {
		ActivityEntity activityEntity = activityRepository.save(modelMapper.map(activity, ActivityEntity.class));
		return modelMapper.map(activityEntity, ActivityDto.class);
	}

	@Override
	public void completeActivity(Long id) {
		activityRepository.completeActivity(id);
	}

	@Override
	public List<ActivityDto> searchArticlesByDisciplineId(Long disciplineId) {
		List<ActivityEntity> acttivity = activityRepository.findByDisciplineId(disciplineId);
		return acttivity.stream().map(a -> modelMapper.map(a, ActivityDto.class))
				.collect(Collectors.toList());
	}
}
