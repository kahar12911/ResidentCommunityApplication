package com.example.residentcommunityapp.controller;

import com.example.residentcommunityapp.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/all")
    public String getAllUsers() {
        return "Hello";
    }
}
