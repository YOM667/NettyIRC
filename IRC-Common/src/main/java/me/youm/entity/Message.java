package me.youm.entity;

import java.io.Serializable;

/**
 * @author : You_M
 * @date : 2022/8/3 12:21 57
 * @projectName : KES-IRC-Server
 * @className : Message
 */
public class Message implements Serializable {
    private String message ="";
    private User user;

    public Message() {
    }

    public Message(String message, User user) {
        this.message = message;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
