package com.example.residentcommunityapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class DemoController {
	@GetMapping("/hello")
   public String helloMethod() {
	return "print Hello world";
	   
   }
}
