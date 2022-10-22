package com.project.eduappbackend.mappers;

import com.project.eduappbackend.dtos.SchoolDto;
import com.project.eduappbackend.models.School;

public interface SchoolMapper {
    SchoolDto toDto(School school);
}
