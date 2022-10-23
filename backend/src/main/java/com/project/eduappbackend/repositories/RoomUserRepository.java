package com.project.eduappbackend.repositories;

import com.project.eduappbackend.models.RoomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomUserRepository extends JpaRepository<RoomUser, Long> {
    @Query("select ru from RoomUser ru where ru.room.roomId = :roomId and ru.user.userId = :userId")
    RoomUser findByRoomAndUser(Integer roomId, Integer userId);

    @Query("select count(*) from RoomUser ru where ru.room.roomId = :roomId")
    int getNumberOfMembers(Integer roomId);
}
