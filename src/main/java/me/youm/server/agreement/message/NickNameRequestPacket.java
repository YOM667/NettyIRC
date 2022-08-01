package me.youm.server.agreement.message;

import me.youm.client.entity.User;

public class NickNameRequestPacket extends Packet{
    private User user;

    public NickNameRequestPacket() {
    }

    public NickNameRequestPacket(User user) {
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
        return PacketCommand.NickNameRequest;
    }
}
