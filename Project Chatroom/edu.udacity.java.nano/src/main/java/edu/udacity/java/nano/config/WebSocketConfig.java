package edu.udacity.java.nano.config;

import edu.udacity.java.nano.chat.WebSocketChatServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig {

    @Bean
    public WebSocketChatServer webSocketChatServerEndpoint() {
        return new WebSocketChatServer();
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
