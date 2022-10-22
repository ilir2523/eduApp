package com.project.eduappbackend.services;

import com.project.eduappbackend.dtos.*;

import java.util.List;

public interface UserService {
    UserDto login(LoginDto loginDto) throws Exception;
    UserDto register(UserDto user) throws Exception;

    List<SchoolDto> getAllSchools();
    List<SchoolTypeDto> getAllSchoolTypes();

    List<SchoolDto> getSchoolsByType(String schoolType) throws Exception;

    List<TopicDto> getAllTopics();

}
