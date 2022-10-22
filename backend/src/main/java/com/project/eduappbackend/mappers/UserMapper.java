package com.project.eduappbackend.mappers;

import com.project.eduappbackend.dtos.UserDto;
import com.project.eduappbackend.models.User;

public interface UserMapper {
    UserDto toDto(User user);
}
