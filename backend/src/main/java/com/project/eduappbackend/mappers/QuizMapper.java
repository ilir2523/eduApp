package com.project.eduappbackend.mappers;

import com.project.eduappbackend.dtos.QuizDto;
import com.project.eduappbackend.models.Quiz;

public interface QuizMapper {
    QuizDto toDto(Quiz quiz);
}
