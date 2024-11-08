package br.com.piel.service.handout.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import br.com.piel.service.handout.service.HandoutService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.piel.service.handout.dto.HandoutDto;
import br.com.piel.service.handout.entity.HandoutEntity;
import br.com.piel.service.handout.repository.HandoutRepository;

@Service
public class HandoutServiceImpl implements HandoutService {

	private final HandoutRepository handoutRepository;
	private final ModelMapper modelMapper;

	public HandoutServiceImpl(HandoutRepository handoutRepository, ModelMapper modelMapper) {
		this.handoutRepository = handoutRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<HandoutDto> searchAllHandouts() {
		List<HandoutEntity> handoutEntities = handoutRepository.findAll();
		return handoutEntities.stream().map(item -> modelMapper.map(item, HandoutDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public HandoutDto searchByHandout(Long id) {
		HandoutEntity handoutEntity = handoutRepository.getReferenceById(id);
		return modelMapper.map(handoutEntity, HandoutDto.class);
	}

	@Override
	public HandoutDto saveHandout(HandoutDto handout) {
		HandoutEntity handoutEntity = handoutRepository.save(modelMapper.map(handout, HandoutEntity.class));
		return modelMapper.map(handoutEntity, HandoutDto.class);
	}
}
