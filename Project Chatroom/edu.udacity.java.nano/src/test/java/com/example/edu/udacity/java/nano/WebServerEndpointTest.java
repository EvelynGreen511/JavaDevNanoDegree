package com.example.edu.udacity.java.nano;


import edu.udacity.java.nano.WebSocketChatApplication;
import edu.udacity.java.nano.model.Message;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingDeque;

import static java.util.Arrays.asList;
import static java.util.concurrent.TimeUnit.SECONDS;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={WebSocketChatApplication.class}, webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebServerEndpointTest {


    @LocalServerPort
    private int port;

    private String URL;
    private WebSocketStompClient stompClient;
    private CompletableFuture<Message> completableFuture;

    @Before
    public void setup() throws Exception {

        URL = "http://localhost:" + port + "/chat";
        completableFuture = new CompletableFuture<>();


        List<Transport> transports = new ArrayList<Transport>(1);
        transports.add(new WebSocketTransport(new StandardWebSocketClient()));
        SockJsClient sockJsClient = new SockJsClient(transports);
        stompClient = new WebSocketStompClient(sockJsClient);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
    }

    @Test
    public void testConnect() throws Exception {
            StompSession stompSession = stompClient
                    .connect(URL, new StompSessionHandlerAdapter() {})
                    .get(1, SECONDS);
            stompSession.subscribe(URL, new DefaultStompFrameHandler());

            String message = "MESSAGE TEST";
            stompSession.send(URL, message.getBytes());

            Message msg = completableFuture.get(10, SECONDS);

           Assert.assertEquals(message, msg.getMsg());
    }


    class DefaultStompFrameHandler implements StompFrameHandler {
        @Override
        public Type getPayloadType(StompHeaders stompHeaders) {
            return Message.class;
        }

        @Override
        public void handleFrame(StompHeaders stompHeaders, Object o) {
            completableFuture.complete((Message) o);
        }
    }


}
