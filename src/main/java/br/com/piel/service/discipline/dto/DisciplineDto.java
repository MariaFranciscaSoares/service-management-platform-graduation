package br.com.piel.service.discipline.dto;

import java.util.List;
import br.com.piel.service.activity.dto.ActivityDto;
import br.com.piel.service.handout.dto.HandoutDto;
import br.com.piel.service.lesson.dto.LessonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DisciplineDto {

    private Long id;

    private String name;

    private List<HandoutDto> handouts;

    private List<ActivityDto> activities;

    private List<LessonDto> lessons;

    private Double grade;

    private Integer attendance;
}
