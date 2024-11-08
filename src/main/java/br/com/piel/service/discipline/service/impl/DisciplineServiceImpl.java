package br.com.piel.service.discipline.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.piel.service.discipline.dto.DisciplineDto;
import br.com.piel.service.discipline.entity.DisciplineEntity;
import br.com.piel.service.discipline.repository.DisciplineRepository;
import br.com.piel.service.discipline.service.DisciplineService;

@Service
public class DisciplineServiceImpl implements DisciplineService {

    private final DisciplineRepository disciplineRepository;
    private final ModelMapper modelMapper;

    public DisciplineServiceImpl(DisciplineRepository disciplineRepository, ModelMapper modelMapper) {
        this.disciplineRepository = disciplineRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DisciplineDto> searchAllDisciplines() {
        List<DisciplineEntity> disciplineEntities = disciplineRepository.findAll();
        return disciplineEntities.stream()
                .map(entity -> modelMapper.map(entity, DisciplineDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public DisciplineDto searchByDiscipline(Long id) {
        DisciplineEntity disciplineEntity = disciplineRepository.getReferenceById(id);
        return modelMapper.map(disciplineEntity, DisciplineDto.class);
    }

    @Override
    public DisciplineDto saveDiscipline(DisciplineDto discipline) {
        DisciplineEntity disciplineEntity = modelMapper.map(discipline, DisciplineEntity.class);
        DisciplineEntity savedEntity = disciplineRepository.save(disciplineEntity);
        return modelMapper.map(savedEntity, DisciplineDto.class);
    }
}
