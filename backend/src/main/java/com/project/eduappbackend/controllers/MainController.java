package com.project.eduappbackend.controllers;

import com.project.eduappbackend.dtos.*;
import com.project.eduappbackend.services.RoomService;
import com.project.eduappbackend.services.UserService;
import com.project.eduappbackend.util.FileSystemRepository;
import com.project.eduappbackend.util.ResponseHandler;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("")
@CrossOrigin(origins = "*")
@Api(tags = "Main Controller")
public class MainController {

    @Autowired
    UserService userService;
    @Autowired
    RoomService roomService;

    @Autowired
    FileSystemRepository fIleSystemRepository;

    @PostMapping("/api/user/login")
    public ResponseEntity<Object> login(@RequestBody LoginDto login) throws Exception {
        return ResponseHandler.generateResponse("OK", HttpStatus.OK, userService.login(login));
    }

    @PostMapping("/api/user/register")
    public ResponseEntity<Object> register(@RequestBody UserDto userDto) throws Exception {
        return ResponseHandler.generateResponse("OK", HttpStatus.OK, userService.register(userDto));
    }

    @GetMapping("/api/schools/all")
    public ResponseEntity<Object> getAllSchools() {
        return ResponseHandler.generateResponse("OK", HttpStatus.OK, userService.getAllSchools());
    }

    @GetMapping("/api/schools/types")
    public ResponseEntity<Object> getAllSchoolTypes() {
        return ResponseHandler.generateResponse("OK", HttpStatus.OK, userService.getAllSchoolTypes());
    }

    @GetMapping("/api/schools")
    public ResponseEntity<Object> getSchoolsByType(@RequestParam("schoolType") String schoolType) throws Exception {
        return ResponseHandler.generateResponse("OK", HttpStatus.OK, userService.getSchoolsByType(schoolType));
    }

    @GetMapping("/api/topics")
    public ResponseEntity<Object> getAllTopics() {
        return ResponseHandler.generateResponse("OK", HttpStatus.OK, userService.getAllTopics());
    }

    @GetMapping("/api/rooms/public")
    public ResponseEntity<Object> getPublicRooms(@RequestParam("topicId") Integer topicId, @RequestParam(value = "schoolTypeId", required = false) Integer schoolTypeId) throws Exception {
        return ResponseHandler.generateResponse("OK", HttpStatus.OK, roomService.getPublicRooms(topicId, schoolTypeId));
    }

    @GetMapping("/api/rooms/user")
    public ResponseEntity<Object> getRoomsByUser(@RequestParam("userId") Integer userId) throws Exception {
        return ResponseHandler.generateResponse("OK", HttpStatus.OK, roomService.getRoomsByUser(userId));
    }

    @GetMapping("/api/rooms/join")
    public ResponseEntity<Object> joinRoom(@RequestParam("roomId") Integer roomId, @RequestParam("userId") Integer userId) throws Exception {
        roomService.joinRoom(userId, roomId);
        return ResponseHandler.generateResponse("OK", HttpStatus.OK);
    }

    @GetMapping("/api/rooms/create")
    public ResponseEntity<Object> createRoom(@RequestBody RoomDto roomDto) throws Exception {
        return ResponseHandler.generateResponse("OK", HttpStatus.OK, roomService.createRoom(roomDto));
    }

    @GetMapping("/api/rooms/checkmember")
    public ResponseEntity<Object> checkIfMemeberRoom(@RequestParam("roomId") Integer roomId, @RequestParam("userId") Integer userId) {
        return ResponseHandler.generateResponse("OK", HttpStatus.OK, roomService.checkIfMemberRoom(roomId, userId));
    }

    @GetMapping("/api/quizes")
    public ResponseEntity<Object> getQuizesOfRoom(@RequestParam("roomId") Integer roomId) throws Exception {
        return ResponseHandler.generateResponse("OK", HttpStatus.OK, roomService.getQuizesForRoom(roomId));
    }

    @PostMapping("/api/quizes/create")
    public ResponseEntity<Object> createQuiz(@RequestBody QuizDto quizDto) throws Exception {
        roomService.createQuiz(quizDto);
        return ResponseHandler.generateResponse("OK", HttpStatus.OK);
    }

    @PostMapping("/api/quizes/takequiz")
    public ResponseEntity<Object> takeQuiz(@RequestBody TakeQuiz takeQuiz) throws Exception {
        return ResponseHandler.generateResponse("OK", HttpStatus.OK, roomService.takeQuiz(takeQuiz));
    }

//    @PostMapping("/api/files/upload")
//    public ResponseEntity<Object> uploadFile(@RequestPart("file") MultipartFile file) throws Exception {
//        return ResponseHandler.generateResponse("OK", HttpStatus.OK, roomService);
//    }
//    
}
