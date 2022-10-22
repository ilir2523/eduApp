package com.project.eduappbackend.services;

import com.project.eduappbackend.dtos.RoomDto;

import java.util.List;

public interface RoomService {

    List<RoomDto> getPublicRooms(Integer topicId, Integer schoolTypeId) throws Exception;

    List<RoomDto> getRoomsByUser(Integer userId) throws Exception;

    void joinRoom(Integer userId, Integer roomId) throws Exception;

    RoomDto createRoom(RoomDto roomDto) throws Exception;
}
