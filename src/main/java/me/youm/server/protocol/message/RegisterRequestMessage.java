package me.youm.server.protocol.message;

import me.youm.server.protocol.Packet;
import me.youm.server.protocol.PacketCommand;

public class RegisterRequestMessage extends Packet {
    private String userName;
    private String passWord;
    private String nickName;

    public RegisterRequestMessage() {
    }

    public RegisterRequestMessage(String userName, String passWord, String nickName) {
        this.userName = userName;
        this.passWord = passWord;
        this.nickName = nickName;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public Byte getCommand() {
        return PacketCommand.RegisterRequest;
    }
}
