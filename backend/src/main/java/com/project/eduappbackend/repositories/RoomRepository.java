package com.project.eduappbackend.repositories;

import com.project.eduappbackend.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("select r from Room r where r.visible = true and r.topic.topicId = :topicId and r.schoolType.schoolTypeId = :schoolTypeId")
    List<Room> getRoomsVisibleByTopicAndSchoolType(Integer topicId, Integer schoolTypeId);

    @Query("select r from Room r where r.visible = true and r.topic.topicId = :topicId")
    List<Room> getRoomsVisibleByTopic(Integer topicId);

    @Query("select r from Room r join RoomUser ru on ru.room.roomId=r.roomId where r.visible = true and ru.user.userId = :userId")
    List<Room> getRoomsByUser(Integer userId);

    @Query("select r from Room r where r.roomId = :roomId")
    Room getByRoomId(Integer roomId);

}
