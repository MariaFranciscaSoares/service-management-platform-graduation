package br.com.piel.service.evaluation.entity;

import br.com.piel.service.discipline.entity.DisciplineEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class EvaluationEntity {

    @Id
    private Long idEvaluation;  // idAvaliacao
    private String evaluationName;  // nomeAvaliacao
    private double evaluationGrade;  // notaAvaliacao

    @ManyToOne
    private DisciplineEntity discipline;  // disciplina

    @OneToMany
    private List<QuestionEntity> questions;  // questoes

    private String status;  // 'aberta' ou 'fechada'

}
