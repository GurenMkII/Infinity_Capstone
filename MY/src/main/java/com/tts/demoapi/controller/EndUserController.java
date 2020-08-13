package com.tts.demoapi.controller;

import java.util.List;

import com.tts.demoapi.EndUserRepository;
import com.tts.demoapi.model.EndUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndUserController {
    
    @Autowired
    EndUserRepository endUserRepository;

    @GetMapping("/")
    public String getWelcome(){
        return "Hello there and welcome";
    }

    @GetMapping("/all")
    public List<EndUser> getUsers(){
        return endUserRepository.findAll();
    }

    @PostMapping("/")
    public void postUser(@RequestBody EndUser endUser){
        endUserRepository.save(endUser);
    }

}