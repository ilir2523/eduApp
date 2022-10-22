package com.project.eduappbackend.mappers.impl;

import com.project.eduappbackend.dtos.SchoolDto;
import com.project.eduappbackend.mappers.SchoolMapper;
import com.project.eduappbackend.mappers.SchoolTypeMapper;
import com.project.eduappbackend.models.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SchoolMapperImpl implements SchoolMapper {
    @Autowired
    SchoolTypeMapper schoolTypeMapper;

    public SchoolDto toDto(School school) {
        SchoolDto schoolDto = new SchoolDto();
        schoolDto.setSchoolId(school.getSchoolId());
        schoolDto.setName(school.getName());
        schoolDto.setLocation(school.getLocation());
        schoolDto.setSchoolTypeDto(schoolTypeMapper.toDto(school.getSchoolType()));
        return schoolDto;
    }
}
