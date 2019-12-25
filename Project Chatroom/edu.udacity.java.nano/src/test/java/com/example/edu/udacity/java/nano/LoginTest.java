package com.example.edu.udacity.java.nano;

import edu.udacity.java.nano.WebSocketChatApplication;
import edu.udacity.java.nano.controller.LoginController;
import edu.udacity.java.nano.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebSocketChatApplication.class}, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc //need this in Spring Boot test
public class LoginTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void loginView() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    public void showUserName() throws Exception {
        this.mockMvc.perform(post ("/chat").param("user", "Evelyn"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("username", "Evelyn"));
    }
    @Test
    public void showChatView() throws Exception {
        this.mockMvc.perform(post ("/chat").param("user", "Evelyn"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("/chat"));
    }


}
