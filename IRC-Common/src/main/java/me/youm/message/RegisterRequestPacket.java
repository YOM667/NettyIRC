package me.youm.message;


import me.youm.entity.User;

public class RegisterRequestPacket extends Packet {
    private User user;


    public RegisterRequestPacket(User user) {
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
        return PacketCommand.RegisterRequest;
    }
}
