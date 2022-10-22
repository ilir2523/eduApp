package com.project.eduappbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {
    private Integer quizId;
    private String name;
    private RoomDto roomDto;
    private UserDto userDto;
    private List<QuizQuestionDto> questions;
    private double result;
}
