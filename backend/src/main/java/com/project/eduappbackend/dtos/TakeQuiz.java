package com.project.eduappbackend.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TakeQuiz {
    private Integer quizId;
    private List<QuestionsAnswers> questionsAnswers;
}
