package com.project.eduappbackend.mappers;

import com.project.eduappbackend.dtos.SchoolTypeDto;
import com.project.eduappbackend.models.SchoolType;

public interface SchoolTypeMapper {
    SchoolTypeDto toDto(SchoolType schoolType);
}
