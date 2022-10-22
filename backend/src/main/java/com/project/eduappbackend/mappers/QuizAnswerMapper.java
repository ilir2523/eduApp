package com.project.eduappbackend.mappers;

import com.project.eduappbackend.dtos.QuizAnswerDto;
import com.project.eduappbackend.models.QuizAnswer;

public interface QuizAnswerMapper {
    QuizAnswerDto toDto(QuizAnswer quizAnswer);
}
