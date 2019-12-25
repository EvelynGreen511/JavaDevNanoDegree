package com.example.edu.udacity.java.nano;


import edu.udacity.java.nano.chat.WebSocketChatServer;
import edu.udacity.java.nano.model.Message;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = {WebSocketChatServer.class}, webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebServerEndpointTest {


    @Value("${local.server.port}")
    private int port;

    private String URL;

    //private CompletableFuture<Message> completableFuture;

    //1. User Counter Login onOpen
    //2. Send / Retrieve Message onMessage
    //3. logout onClose

    @Before
    public void setup() {
        URL = "https://localhost:" + port + "/chat";
    }

    @Test
    public void UserAndCounterAfterLogin() throws Exception  {


        //assertEquals("Evelyn", msg.getUsername());
        //assertEquals(1, msg.getOnlineCount());
    }




}
