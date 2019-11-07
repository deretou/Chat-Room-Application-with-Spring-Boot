package edu.udacity.java.nano.model;


import com.alibaba.fastjson.JSON;
/**
 * WebSocket message model
 */

public class Message {
    private MessageType type;
    private String content;
    private String sender;
    private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int onlineCount) {
        this.counter = onlineCount;
    }

    public enum MessageType {
        ENTER,
        CHAT,
        LEAVE
    }


    public Message(MessageType type, String sender, String content, int counter) {
        this.type = type;
        this.sender = sender;
        this.content = content;
        this.counter = counter;
    }



    public static String jsonStr(String type, String sender, String content, int counter) {
        return JSON.toJSONString(new Message( MessageType.valueOf(type), sender, content, counter));
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}


