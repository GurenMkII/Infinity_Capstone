package com.tts.demoapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EndUser {

    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public EndUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public EndUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    
}