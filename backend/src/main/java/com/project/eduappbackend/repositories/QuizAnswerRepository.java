package com.project.eduappbackend.repositories;

import com.project.eduappbackend.models.QuizAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizAnswerRepository extends JpaRepository<QuizAnswer, Long> {

    @Query("select q from QuizAnswer q where q.question.quizQuestionId = :questionId")
    List<QuizAnswer> findByQuestionId(Integer questionId);

    @Query("select q from QuizAnswer q where q.quizAnswerId = :answerId and q.question.quizQuestionId = :questionId")
    QuizAnswer findByQuestionAndAnswer(Integer questionId, Integer answerId);
}
