package com.project.eduappbackend.mappers;

import com.project.eduappbackend.dtos.TopicDto;
import com.project.eduappbackend.models.Topic;

public interface TopicMapper {
    TopicDto toDto(Topic topic);
}
