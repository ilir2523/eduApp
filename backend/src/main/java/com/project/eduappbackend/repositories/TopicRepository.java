package com.project.eduappbackend.repositories;

import com.project.eduappbackend.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    @Query("select t from Topic t where t.topicId=:id")
    Topic findByTopicId(Integer id);
}
