package br.com.piel.service.activity.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.piel.service.activity.dto.ActivityDto;
import br.com.piel.service.activity.service.ActivityService;

@RestController
@RequestMapping("activity")
@CrossOrigin
public class ActivityController {

	private final ActivityService service;

	public ActivityController(ActivityService service) {
		this.service = service;
	}

	@GetMapping("/all")
	public ResponseEntity<List<ActivityDto>> getAllActivities() {
		List<ActivityDto> allActivities = service.searchAllActivities();
		return ResponseEntity.status(HttpStatus.OK).body(allActivities);
	}

	@GetMapping("/byId/{id}")
	public ResponseEntity<ActivityDto> getActivityById(@PathVariable("id") Long id) {
		ActivityDto activity = service.searchByActivity(id);
		return ResponseEntity.status(HttpStatus.OK).body(activity);
	}

	@PostMapping("/save")
	public ResponseEntity<ActivityDto> saveActivity(@RequestBody ActivityDto activity) {
		ActivityDto activitySave = service.saveActivity(activity);
		return ResponseEntity.status(HttpStatus.CREATED).body(activitySave);
	}

	@PatchMapping("/complete/{id}")
	public ResponseEntity<Void> concluirAtividade(@PathVariable("id") Long id) {
		service.completeActivity(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/byDiscipline/{disciplineId}")
	public ResponseEntity<List<ActivityDto>> getArticlesByDisciplineId(@PathVariable("disciplineId") Long disciplineId) {
		List<ActivityDto> articles = service.searchArticlesByDisciplineId(disciplineId);
		return ResponseEntity.status(HttpStatus.OK).body(articles);
	}
}
