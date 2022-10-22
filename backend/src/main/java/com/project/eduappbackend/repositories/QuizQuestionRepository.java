package com.project.eduappbackend.repositories;

import com.project.eduappbackend.dtos.QuizQuestionDto;
import com.project.eduappbackend.models.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long> {

    @Query("select q from QuizQuestion q where q.quiz.quizId = :quizId")
    List<QuizQuestion> findByQuizId(Integer quizId);
}
