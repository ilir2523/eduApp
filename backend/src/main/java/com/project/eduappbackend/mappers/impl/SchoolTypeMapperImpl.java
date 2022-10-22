package com.project.eduappbackend.mappers.impl;

import com.project.eduappbackend.dtos.SchoolTypeDto;
import com.project.eduappbackend.mappers.SchoolTypeMapper;
import com.project.eduappbackend.models.SchoolType;
import org.springframework.stereotype.Component;

@Component
public class SchoolTypeMapperImpl implements SchoolTypeMapper {
    public SchoolTypeDto toDto(SchoolType schoolType) {
        SchoolTypeDto schoolTypeDto = new SchoolTypeDto();
        schoolTypeDto.setSchoolTypeId(schoolType.getSchoolTypeId());
        schoolTypeDto.setType(schoolType.getType());
        return schoolTypeDto;
    }
}
