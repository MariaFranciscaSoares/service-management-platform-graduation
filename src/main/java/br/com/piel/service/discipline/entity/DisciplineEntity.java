package br.com.piel.service.discipline.entity;

import java.util.List;

import br.com.piel.service.activity.entity.ActivityEntity;
import br.com.piel.service.handout.entity.HandoutEntity;
import br.com.piel.service.lesson.entity.LessonEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class DisciplineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name = "discipline_id")
    private List<HandoutEntity> handouts;

    @OneToMany
    @JoinColumn(name = "discipline_id")
    private List<ActivityEntity> activities;

    @OneToMany
    @JoinColumn(name = "discipline_id")
    private List<LessonEntity> lessons;

    @Column(nullable = false)
    private Double grade;

    @Column(nullable = false)
    private Integer attendance;
}
