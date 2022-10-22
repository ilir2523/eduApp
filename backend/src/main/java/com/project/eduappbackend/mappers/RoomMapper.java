package com.project.eduappbackend.mappers;

import com.project.eduappbackend.dtos.RoomDto;
import com.project.eduappbackend.models.Room;

public interface RoomMapper {
    RoomDto toDto(Room room);
}
