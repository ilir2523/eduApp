package com.project.eduappbackend.services;

import com.project.eduappbackend.dtos.QuizDto;
import com.project.eduappbackend.dtos.RoomDto;
import com.project.eduappbackend.dtos.TakeQuiz;

import java.util.List;

public interface RoomService {

    List<RoomDto> getPublicRooms(Integer topicId, Integer schoolTypeId) throws Exception;

    List<RoomDto> getRoomsByUser(Integer userId) throws Exception;

    void joinRoom(Integer userId, Integer roomId) throws Exception;

    RoomDto createRoom(RoomDto roomDto) throws Exception;

    boolean checkIfMemberRoom(Integer roomId, Integer userId);

    List<QuizDto> getQuizesForRoom(Integer roomId) throws Exception;

    void createQuiz(QuizDto quizDto) throws Exception;

    QuizDto takeQuiz(TakeQuiz takeQuiz) throws Exception;
}
