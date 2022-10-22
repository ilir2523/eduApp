package com.project.eduappbackend.services.impl;

import com.project.eduappbackend.dtos.LoginDto;
import com.project.eduappbackend.dtos.SchoolDto;
import com.project.eduappbackend.dtos.SchoolTypeDto;
import com.project.eduappbackend.dtos.UserDto;
import com.project.eduappbackend.mappers.SchoolMapper;
import com.project.eduappbackend.mappers.SchoolTypeMapper;
import com.project.eduappbackend.mappers.UserMapper;
import com.project.eduappbackend.models.School;
import com.project.eduappbackend.models.SchoolType;
import com.project.eduappbackend.models.User;
import com.project.eduappbackend.repositories.SchoolRepository;
import com.project.eduappbackend.repositories.SchoolTypeRepository;
import com.project.eduappbackend.repositories.UserRepository;
import com.project.eduappbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    SchoolRepository schoolRepository;
    @Autowired
    SchoolTypeRepository schoolTypeRepository;
    @Autowired
    UserMapper userMapper;
    @Autowired
    SchoolMapper schoolMapper;
    @Autowired
    SchoolTypeMapper schoolTypeMapper;

    public UserDto login(LoginDto loginDto) throws Exception {
        User user = userRepository.findByUsername(loginDto.getUsername());
        if (user==null)
            throw new Exception("User does not exist.");
        if (user.getPassword().equals(loginDto.getPassword())) {
            return userMapper.toDto(user);
        }
        else throw new Exception("Wrong password.");
    }

    public UserDto register(UserDto userDto) throws Exception {
        if (userRepository.findByUsername(userDto.getUsername())!=null)
            throw new Exception("Username already exists.");
        User registerUser = new User();
        registerUser.setFirstName(userDto.getFirstName());
        registerUser.setLastName(userDto.getLastName());
        registerUser.setBirthday(userDto.getBirthday());
        registerUser.setActive(true);
        School school = schoolRepository.findById(userDto.getSchoolDto().getSchoolId());
        if (school==null) throw new Exception("School does not exist.");
        registerUser.setSchool(school);
        registerUser.setUsername(userDto.getUsername());
        registerUser.setPassword(userDto.getPassword());
        userRepository.save(registerUser);
        return userMapper.toDto(registerUser);
    }

    @Override
    public List<SchoolDto> getAllSchools() {
        List<School> schools = schoolRepository.findAll();
        List<SchoolDto> schoolDtoList = new ArrayList<>();
        if (schools!=null && !schools.isEmpty()) {
            for (School school : schools) {
                SchoolDto schoolDto = new SchoolDto();
                schoolDto = schoolMapper.toDto(school);
                schoolDtoList.add(schoolDto);
            }
        }
        return schoolDtoList;
    }

    @Override
    public List<SchoolTypeDto> getAllSchoolTypes() {
        List<SchoolType> schoolTypes = schoolTypeRepository.findAll();
        List<SchoolTypeDto> schoolTypeDtoList = new ArrayList<>();
        if (schoolTypes!=null && !schoolTypes.isEmpty()) {
            for (SchoolType schoolType : schoolTypes) {
                SchoolTypeDto schoolTypeDto = new SchoolTypeDto();
                schoolTypeDto = schoolTypeMapper.toDto(schoolType);
                schoolTypeDtoList.add(schoolTypeDto);
            }
        }
        return schoolTypeDtoList;
    }

    @Override
    public List<SchoolDto> getSchoolsByType(String schoolType) throws Exception {
        if (schoolTypeRepository.findByName(schoolType)==null)
            throw new Exception("School type was not found.");
        List<School> schools = schoolRepository.findBySchoolType(schoolType);
        List<SchoolDto> schoolDtoList = new ArrayList<>();
        if (schools!=null && !schools.isEmpty()) {
            for (School school : schools) {
                SchoolDto schoolDto = new SchoolDto();
                schoolDto = schoolMapper.toDto(school);
                schoolDtoList.add(schoolDto);
            }
        }
        return schoolDtoList;
    }
}
