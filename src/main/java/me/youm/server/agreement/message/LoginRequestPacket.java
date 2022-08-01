package me.youm.server.agreement.message;

import me.youm.client.entity.User;

public class LoginRequestPacket extends Packet {
    private User user;

    public LoginRequestPacket() {
    }

    public LoginRequestPacket(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Byte getCommand() {
        return PacketCommand.LoginRequest;
    }
}
