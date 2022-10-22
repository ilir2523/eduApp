package com.project.eduappbackend.mappers.impl;

import com.project.eduappbackend.dtos.QuizAnswerDto;
import com.project.eduappbackend.mappers.QuizAnswerMapper;
import com.project.eduappbackend.models.QuizAnswer;
import org.springframework.stereotype.Component;

@Component
public class QuizAnswerMapperImpl implements QuizAnswerMapper {
    @Override
    public QuizAnswerDto toDto(QuizAnswer quizAnswer) {
        QuizAnswerDto quizAnswerDto = new QuizAnswerDto();
        quizAnswerDto.setQuizAnswerId(quizAnswer.getQuizAnswerId());
        quizAnswerDto.setAnswer(quizAnswer.getAnswer());
        quizAnswerDto.setCorrect(quizAnswer.isCorrect());
        return quizAnswerDto;
    }
}
