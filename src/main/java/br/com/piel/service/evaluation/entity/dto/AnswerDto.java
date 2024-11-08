package br.com.piel.service.evaluation.entity.dto;

import lombok.Data;

@Data
public class AnswerDto {
    private Long idAnswer;  // idResposta
    private String answerText;  // textoResposta
    private boolean correct;  // correta
    private boolean selected;  // selecionada
}
