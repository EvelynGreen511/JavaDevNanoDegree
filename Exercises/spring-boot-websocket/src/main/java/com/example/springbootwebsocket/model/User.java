package com.example.springbootwebsocket.model;

//Message Class
public class User {

    public User(String name) {
        this.name = name;
    }

    public User() {};

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String name;

}
