package com.project.eduappbackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="quiz_questions")
@Getter
@Setter
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quizquestion_id")
    private int quizQuestionId;

    @Column(name = "question")
    private String question;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="quiz_id", referencedColumnName = "quiz_id", nullable = false)
    private Quiz quiz;
}
