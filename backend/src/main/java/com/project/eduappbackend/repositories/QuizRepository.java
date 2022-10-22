package com.project.eduappbackend.repositories;

import com.project.eduappbackend.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @Query("select q from Quiz q where q.room.roomId = :roomId")
    List<Quiz> getQuizesByRoom(Integer roomId);
}
