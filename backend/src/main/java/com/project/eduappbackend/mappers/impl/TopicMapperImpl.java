package com.project.eduappbackend.mappers.impl;

import com.project.eduappbackend.dtos.TopicDto;
import com.project.eduappbackend.mappers.TopicMapper;
import com.project.eduappbackend.models.Topic;
import org.springframework.stereotype.Component;

@Component
public class TopicMapperImpl implements TopicMapper {

    @Override
    public TopicDto toDto(Topic topic) {
        TopicDto topicDto = new TopicDto();
        topicDto.setTopicId(topic.getTopicId());
        topicDto.setName(topic.getName());
        return topicDto;
    }
}
