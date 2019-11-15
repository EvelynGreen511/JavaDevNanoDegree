package edu.udacity.java.nano.model;

import javax.validation.constraints.NotBlank;

public class User {

    @NotBlank(message="username cannot be empty")
    private String username;

    public User() {};

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
