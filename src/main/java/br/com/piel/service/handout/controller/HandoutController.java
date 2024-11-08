package br.com.piel.service.handout.controller;

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

import br.com.piel.service.handout.dto.HandoutDto;
import br.com.piel.service.handout.service.HandoutService;

@RestController
@RequestMapping("handout")
@CrossOrigin
public class HandoutController {

	private final HandoutService service;

	public HandoutController(HandoutService service) {
		this.service = service;
	}

	@GetMapping("/all")
	public ResponseEntity<List<HandoutDto>> getAllHandouts() {
		List<HandoutDto> allHandouts = service.searchAllHandouts();
		return ResponseEntity.status(HttpStatus.OK).body(allHandouts);
	}

	@GetMapping("/byId/{id}")
	public ResponseEntity<HandoutDto> getHandoutById(@PathVariable("id") Long id) {
		HandoutDto handout = service.searchByHandout(id);
		return ResponseEntity.status(HttpStatus.OK).body(handout);
	}

	@PostMapping("/save")
	public ResponseEntity<HandoutDto> saveHandout(@RequestBody HandoutDto handout) {
		HandoutDto handoutSaved = service.saveHandout(handout);
		return ResponseEntity.status(HttpStatus.CREATED).body(handoutSaved);
	}
}
