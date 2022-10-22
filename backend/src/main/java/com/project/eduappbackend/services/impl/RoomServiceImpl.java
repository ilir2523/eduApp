package com.project.eduappbackend.services.impl;

import com.project.eduappbackend.dtos.RoomDto;
import com.project.eduappbackend.mappers.*;
import com.project.eduappbackend.models.*;
import com.project.eduappbackend.repositories.*;
import com.project.eduappbackend.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    SchoolTypeRepository schoolTypeRepository;
    @Autowired
    TopicRepository topicRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    RoomUserRepository roomUserRepository;
    @Autowired
    UserMapper userMapper;
    @Autowired
    SchoolMapper schoolMapper;
    @Autowired
    SchoolTypeMapper schoolTypeMapper;
    @Autowired
    TopicMapper topicMapper;
    @Autowired
    RoomMapper roomMapper;

    @Override
    public List<RoomDto> getPublicRooms(Integer topicId, Integer schoolTypeId) throws Exception {
        List<Room> rooms = new ArrayList<>();
        if (topicRepository.findByTopicId(topicId)==null)
            throw new Exception("Topic does not exist.");
        if (schoolTypeId!=null) {
            if (schoolTypeRepository.findBySchoolTypeId(schoolTypeId)==null)
                throw new Exception("School type does not exist.");
            rooms = roomRepository.getRoomsVisibleByTopicAndSchoolType(topicId, schoolTypeId);
        }
        rooms = roomRepository.getRoomsVisibleByTopic(topicId);

        List<RoomDto> roomDtoList = new ArrayList<>();
        if (rooms!=null && !rooms.isEmpty()) {
            for (Room room : rooms) {
                RoomDto roomDto = new RoomDto();
                roomDto = roomMapper.toDto(room);
                roomDtoList.add(roomDto);
            }
        }
        return roomDtoList;
    }

    @Override
    public List<RoomDto> getRoomsByUser(Integer userId) throws Exception {
        if (userRepository.findByUserId(userId)==null)
            throw new Exception("User does not exist.");
        List<Room> rooms = roomRepository.getRoomsByUser(userId);
        List<RoomDto> roomDtoList = new ArrayList<>();
        if (rooms!=null && !rooms.isEmpty()) {
            for (Room room : rooms) {
                RoomDto roomDto = new RoomDto();
                roomDto = roomMapper.toDto(room);
                roomDtoList.add(roomDto);
            }
        }
        return roomDtoList;
    }

    @Override
    public void joinRoom(Integer userId, Integer roomId) throws Exception {
        User user = userRepository.findByUserId(userId);
        if (user==null) throw new Exception("User does not exist.");
        Room room = roomRepository.getByRoomId(roomId);
        if (room==null) throw new Exception("Room does not exist.");
        RoomUser roomUser = roomUserRepository.findByRoomAndUser(roomId, userId);
        if (roomUser!=null)  throw new Exception("You are already a member of this room.");
        if (!room.isVisible()) throw new Exception("You cannot join this room.");
        RoomUser roomUserNew = new RoomUser();
        roomUserNew.setUser(user);
        roomUserNew.setRoom(room);
        roomUserRepository.save(roomUserNew);
    }

    @Override
    public RoomDto createRoom(RoomDto roomDto) throws Exception {
        Room room = new Room();
        room.setName(roomDto.getName());
        room.setVisible(room.isVisible());
        Topic topic = topicRepository.findByTopicId(roomDto.getTopicDto().getTopicId());
        if (topic==null) throw new Exception("Topic does not exist.");
        room.setTopic(topic);
        SchoolType schoolType = schoolTypeRepository.findBySchoolTypeId(roomDto.getSchoolTypeDto().getSchoolTypeId());
        if (schoolType==null) throw new Exception("School type does not exist.");
        room.setSchoolType(schoolType);
        User creator = userRepository.findByUserId(roomDto.getCreator().getUserId());
        if (creator==null) throw new Exception("User does not exist.");
        room.setCreator(creator);
        roomRepository.save(room);
        return roomMapper.toDto(room);
    }
}
