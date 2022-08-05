package me.youm.message;

import me.youm.entity.User;

/**
 * @author : You_M
 * @date : 2022/8/5 16:58 12
 * @projectName : KES-IRC-Server
 * @className : BanUserRequestPacket
 */
public class BanUserRequestPacket extends Packet{
    private String userName;

    public BanUserRequestPacket() {
    }

    public BanUserRequestPacket(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String user) {
        this.userName = user;
    }

    @Override
    public Byte getCommand() {
        return PacketCommand.BanUserRequest;
    }
}
