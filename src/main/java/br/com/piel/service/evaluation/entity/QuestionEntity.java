package br.com.piel.service.evaluation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class QuestionEntity {
    @Id
    private Long idQuestion;
    private String statement;

    @OneToMany
    private List<AnswerEntity> answers;
}
