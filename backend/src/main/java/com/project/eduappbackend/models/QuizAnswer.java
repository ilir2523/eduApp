package com.project.eduappbackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="quiz_answers")
@Getter
@Setter
public class QuizAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quizanswers_id")
    private Integer quizAnswerId;

    @Column(name = "answer")
    private String answer;

    @Column(name = "correct")
    private boolean correct;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="quizquestion_id", referencedColumnName = "quizquestion_id", nullable = false)
    private QuizQuestion question;
}
