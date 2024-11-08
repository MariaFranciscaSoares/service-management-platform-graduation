package br.com.piel.service.handout.service;

import java.util.List;

import br.com.piel.service.handout.dto.HandoutDto;

public interface HandoutService {

	List<HandoutDto> searchAllHandouts();

	HandoutDto searchByHandout(Long id);

	HandoutDto saveHandout(HandoutDto handout);
}
