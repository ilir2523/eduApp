package com.project.eduappbackend.services.impl;

import com.project.eduappbackend.dtos.*;
import com.project.eduappbackend.mappers.*;
import com.project.eduappbackend.models.*;
import com.project.eduappbackend.repositories.*;
import com.project.eduappbackend.services.UserService;
import org.mindrot.jbcrypt.BCrypt;
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
    TopicRepository topicRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    UserMapper userMapper;
    @Autowired
    SchoolMapper schoolMapper;
    @Autowired
    SchoolTypeMapper schoolTypeMapper;
    @Autowired
    TopicMapper topicMapper;
    @Autowired
    RoomMapper roomMapper;

    public UserDto login(LoginDto loginDto) throws Exception {
        User user = userRepository.findByUsername(loginDto.getUsername());
        if (user==null)
            throw new Exception("User does not exist.");
        if (BCrypt.checkpw(loginDto.getPassword(), user.getPassword()))
            return userMapper.toDto(user);
        else throw new Exception("Wrong password.");
    }

    public UserDto register(UserDto userDto) throws Exception {
        if (userRepository.findByUsername(userDto.getUsername())!=null)
            throw new Exception("Username already exists.");
        User registerUser = new User();
        String hashedPass = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
        registerUser.setUsername(userDto.getUsername());
        registerUser.setPassword(hashedPass);
        registerUser.setFirstName(userDto.getFirstName());
        registerUser.setLastName(userDto.getLastName());
        registerUser.setBirthday(userDto.getBirthday());
        registerUser.setActive(true);
        if (userDto.getSchoolDto()!=null) {
            School school = schoolRepository.findById(userDto.getSchoolDto().getSchoolId());
            if (school==null) throw new Exception("School does not exist.");
            registerUser.setSchool(school);
        }
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
        if (schoolTypeRepository.findByType(schoolType)==null)
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

    @Override
    public List<TopicDto> getAllTopics() {
        List<Topic> topics = topicRepository.findAll();
        List<TopicDto> topicDtoList = new ArrayList<>();
        if (topics!=null && !topics.isEmpty()) {
            for (Topic topic : topics) {
                TopicDto topicDto = new TopicDto();
                topicDto = topicMapper.toDto(topic);
                topicDtoList.add(topicDto);
            }
        }
        return topicDtoList;
    }

}
