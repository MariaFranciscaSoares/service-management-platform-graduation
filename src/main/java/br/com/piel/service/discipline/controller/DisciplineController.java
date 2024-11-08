package br.com.piel.service.discipline.controller;

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

import br.com.piel.service.discipline.dto.DisciplineDto;
import br.com.piel.service.discipline.service.DisciplineService;

@RestController
@RequestMapping("discipline")
@CrossOrigin
public class DisciplineController {

    private final DisciplineService service;

    public DisciplineController(DisciplineService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<DisciplineDto>> getAllDisciplines() {
        List<DisciplineDto> allDisciplines = service.searchAllDisciplines();
        return ResponseEntity.status(HttpStatus.OK).body(allDisciplines);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<DisciplineDto> getDisciplineById(@PathVariable("id") Long id) {
        DisciplineDto discipline = service.searchByDiscipline(id);
        return ResponseEntity.status(HttpStatus.OK).body(discipline);
    }

    @PostMapping("/save")
    public ResponseEntity<DisciplineDto> saveDiscipline(@RequestBody DisciplineDto discipline) {
        DisciplineDto disciplineSave = service.saveDiscipline(discipline);
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplineSave);
    }
}
