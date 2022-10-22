package com.project.eduappbackend.mappers;

import com.project.eduappbackend.dtos.QuizQuestionDto;
import com.project.eduappbackend.models.QuizQuestion;

public interface QuizQuestionMapper {
    QuizQuestionDto toDto(QuizQuestion quizQuestion);
}
