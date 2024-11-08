package br.com.piel.service.discipline.service;

import java.util.List;
import br.com.piel.service.discipline.dto.DisciplineDto;

public interface DisciplineService {

    List<DisciplineDto> searchAllDisciplines();

    DisciplineDto searchByDiscipline(Long id);

    DisciplineDto saveDiscipline(DisciplineDto discipline);
}
