package com.example.edu.udacity.java.nano;

import edu.udacity.java.nano.WebSocketChatApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebSocketChatApplication.class}, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc //need this in Spring Boot test
public class LogoutTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void logoutView() throws Exception {
        //1. Login
        //2. Logout Button

    }
}
