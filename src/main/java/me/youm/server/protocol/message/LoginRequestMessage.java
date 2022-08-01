package me.youm.server.protocol.message;

import me.youm.server.protocol.Packet;
import me.youm.server.protocol.PacketCommand;

public class LoginRequestMessage extends Packet {

    private String userName;
    private String passWord;

    public LoginRequestMessage() {
    }

    public LoginRequestMessage(String userName, String passWord) {
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
