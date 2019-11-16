package edu.udacity.java.nano.model;

/**
 * WebSocket message model
 */
public class Message {

    public enum TYPE {
        ENTER,
        SPEAK,
        LEAVE
    }

    private String msg;
    private String username;
    private Enum type;
    private int onlineCount;

    public Message() {}

    public Message(String msg, int onlineCount) {
        this.msg = msg;
        this.onlineCount = onlineCount;
    }

    public Message(String msg, String username, Enum type, int onlineCount) {
        this.msg = msg;
        this.username = username;
        this.type = type;
        this.onlineCount = onlineCount;
    }

    public Message(String username, Enum type, int onlineCount) {
        this.username = username;
        this.type = type;
        this.onlineCount = onlineCount;
    }

    public Message(String username) {
        this.username = username;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Enum getType() {
        return type;
    }

    public void setType(Enum type) {
        this.type = type;
    }

    public int getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(int onlineCount) {
        this.onlineCount = onlineCount;
    }
}
