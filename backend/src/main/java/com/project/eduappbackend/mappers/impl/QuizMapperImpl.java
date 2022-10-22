package com.project.eduappbackend.mappers.impl;

import com.project.eduappbackend.dtos.QuizDto;
import com.project.eduappbackend.mappers.QuizMapper;
import com.project.eduappbackend.mappers.RoomMapper;
import com.project.eduappbackend.mappers.UserMapper;
import com.project.eduappbackend.models.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuizMapperImpl implements QuizMapper {

    @Autowired
    RoomMapper roomMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public QuizDto toDto(Quiz quiz) {
        QuizDto quizDto = new QuizDto();
        quizDto.setQuizId(quiz.getQuizId());
        quizDto.setName(quiz.getName());
        quizDto.setRoomDto(roomMapper.toDto(quiz.getRoom()));
        quizDto.setUserDto(userMapper.toDto(quiz.getUser()));
        return quizDto;
    }
}
