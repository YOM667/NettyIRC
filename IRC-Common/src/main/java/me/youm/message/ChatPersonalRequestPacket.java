package me.youm.message;

import me.youm.entity.Message;
import me.youm.entity.User;

/**
 * @author : You_M
 * @date : 2022/8/6 11:38 14
 * @projectName : KES-IRC-Server
 * @className : ChatPersonalRequestPacket
 */
public class ChatPersonalRequestPacket extends Packet{

    private String username;
    private Message message;

    public ChatPersonalRequestPacket() {
    }

    public ChatPersonalRequestPacket(String to, Message message) {
        this.username = to;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String to) {
        this.username = to;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return PacketCommand.ChatPersonalRequest;
    }
}
