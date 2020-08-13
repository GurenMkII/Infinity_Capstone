package com.tts.demoapi;

import com.tts.demoapi.model.EndUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EndUserRepository extends JpaRepository<EndUser, Long> {

    EndUser findByName(String name);
    
}