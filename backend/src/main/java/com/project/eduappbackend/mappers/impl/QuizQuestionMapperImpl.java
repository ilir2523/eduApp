package com.project.eduappbackend.mappers.impl;

import com.project.eduappbackend.dtos.QuizQuestionDto;
import com.project.eduappbackend.mappers.QuizQuestionMapper;
import com.project.eduappbackend.models.QuizQuestion;
import org.springframework.stereotype.Component;

@Component
public class QuizQuestionMapperImpl implements QuizQuestionMapper {
    @Override
    public QuizQuestionDto toDto(QuizQuestion quizQuestion) {
        QuizQuestionDto quizQuestionDto = new QuizQuestionDto();
        quizQuestionDto.setQuizQuestionId(quizQuestion.getQuizQuestionId());
        quizQuestionDto.setQuestion(quizQuestion.getQuestion());
        return quizQuestionDto;
    }
}
