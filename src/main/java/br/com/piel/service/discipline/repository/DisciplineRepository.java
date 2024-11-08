package br.com.piel.service.discipline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.piel.service.discipline.entity.DisciplineEntity;

public interface DisciplineRepository extends JpaRepository<DisciplineEntity, Long> {

}
