package com.project.eduappbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int userId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Date birthday;
    private boolean active;
    private SchoolDto schoolDto;
}
