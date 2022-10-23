package com.project.eduappbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private Integer roomId;
    private String name;
    private boolean visible;
    private TopicDto topicDto;
    private SchoolTypeDto schoolTypeDto;
    private UserDto creator;
    private int members;
}
