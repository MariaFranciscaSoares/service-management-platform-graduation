package br.com.piel.service.handout.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.piel.service.handout.entity.HandoutEntity;

public interface HandoutRepository extends JpaRepository<HandoutEntity, Long> {

}