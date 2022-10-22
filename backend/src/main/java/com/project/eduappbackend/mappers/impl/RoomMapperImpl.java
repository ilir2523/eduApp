package com.project.eduappbackend.mappers.impl;

import com.project.eduappbackend.dtos.RoomDto;
import com.project.eduappbackend.mappers.RoomMapper;
import com.project.eduappbackend.mappers.SchoolTypeMapper;
import com.project.eduappbackend.mappers.TopicMapper;
import com.project.eduappbackend.mappers.UserMapper;
import com.project.eduappbackend.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomMapperImpl implements RoomMapper {

    @Autowired
    TopicMapper topicMapper;
    @Autowired
    SchoolTypeMapper schoolTypeMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public RoomDto toDto(Room room) {
        RoomDto roomDto = new RoomDto();
        roomDto.setRoomId(room.getRoomId());
        roomDto.setName(room.getName());
        roomDto.setVisible(room.isVisible());
        if (room.getSchoolType()!=null)
            roomDto.setSchoolTypeDto(schoolTypeMapper.toDto(room.getSchoolType()));
        if (room.getTopic()!=null)
            roomDto.setTopicDto(topicMapper.toDto(room.getTopic()));
        roomDto.setCreator(userMapper.toDto(room.getCreator()));

        return roomDto;
    }
}
