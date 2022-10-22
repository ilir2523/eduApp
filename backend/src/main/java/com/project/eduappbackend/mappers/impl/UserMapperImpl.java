package com.project.eduappbackend.mappers.impl;

import com.project.eduappbackend.dtos.UserDto;
import com.project.eduappbackend.mappers.SchoolMapper;
import com.project.eduappbackend.mappers.UserMapper;
import com.project.eduappbackend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Autowired
    SchoolMapper schoolMapper;

    @Override
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUsername(user.getUsername());
        userDto.setBirthday(user.getBirthday());
        userDto.setActive(user.isActive());
        if (user.getSchool()!=null)
            userDto.setSchoolDto(schoolMapper.toDto(user.getSchool()));
        return userDto;
    }

}
