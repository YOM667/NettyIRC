package me.youm.server.agreement.message;

import me.youm.client.entity.User;

public class LoginRequestPacket extends Packet {
    private String userName;
    private String passWord;

    public LoginRequestPacket() {
    }

    public LoginRequestPacket(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public Byte getCommand() {
        return PacketCommand.LoginRequest;
    }
}
