package br.com.piel.service.evaluation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AnswerEntity {
    @Id
    private Long idAnswer;
    private String answerText;
    private boolean correct;
    private boolean selected = false;
}