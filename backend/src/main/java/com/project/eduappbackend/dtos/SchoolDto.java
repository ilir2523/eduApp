package com.project.eduappbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {
    private int schoolId;
    private String name;
    private String location;
    private SchoolTypeDto schoolTypeDto;
}
