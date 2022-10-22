package com.project.eduappbackend.controllers;

import com.project.eduappbackend.dtos.LoginDto;
import com.project.eduappbackend.dtos.UserDto;
import com.project.eduappbackend.services.UserService;
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
    public ResponseEntity<Object> getAllSchoolTypes(@RequestParam("schoolType") String schoolType) throws Exception {
        return ResponseHandler.generateResponse("OK", HttpStatus.OK, userService.getSchoolsByType(schoolType));
    }
}
