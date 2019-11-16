package edu.udacity.java.nano.chat;

import com.google.gson.Gson;
import edu.udacity.java.nano.model.Message;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * WebSocket Server
 *
 * @see ServerEndpoint WebSocket Client
 * @see Session   WebSocket Session
 */

@Component
@ServerEndpoint("/chat")
public class WebSocketChatServer {

    /**
     * All chat sessions.
     */
    private static Map<String, Session> onlineSessions = new ConcurrentHashMap<>();

    private static void sendMessageToAll(String msg) throws IOException {
        //TODO: add send message method.
        Iterator<Map.Entry<String, Session>> iterator = onlineSessions.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry storedSession = (Map.Entry)iterator.next();
            ((Session)storedSession.getValue()).getBasicRemote().sendText(msg);
        }
    }

    /**
     * Open connection, 1) add session, 2) add user.
     */
    @OnOpen
    public void onOpen(Session session) throws IOException {
        //TODO: add on open connection.
        onlineSessions.put(session.getId(), session);

        Message message = new Message(session.getId(), Message.TYPE.ENTER, onlineSessions.size());
        sendMessageToAll(new Gson().toJson(message));
    }

    /**
     * Send message, 1) get username and session, 2) send message to all.
     */
    @OnMessage
    public void onMessage(Session session, String jsonStr) throws IOException {
        //TODO: add send message.
        Gson gson = new Gson();
        Message msg = gson.fromJson(jsonStr, Message.class);
        msg.setType(Message.TYPE.SPEAK);
        msg.setOnlineCount(onlineSessions.size());
        sendMessageToAll(gson.toJson(msg));
    }

    /**
     * Close connection, 1) remove session, 2) update user.
     */
    @OnClose
    public void onClose(Session session) throws IOException {
        //TODO: add close connection.

        String userId = session.getId();
        onlineSessions.remove(userId, session);

        Message message = new Message(userId, Message.TYPE.LEAVE, onlineSessions.size());
        sendMessageToAll(new Gson().toJson(message));
    }

    /**
     * Print exception.
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }
}
