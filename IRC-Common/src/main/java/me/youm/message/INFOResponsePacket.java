package me.youm.message;

import me.youm.entity.User;

/**
 * @author : You_M
 * @date : 2022/8/3 11:16 02
 * @projectName : KES-IRC-Server
 * @className : INFOResponsePacket
 */
public class INFOResponsePacket extends Packet{
    private User user;
    private String reason;
    private boolean success;
    public INFOResponsePacket() {

    }

    public INFOResponsePacket(User user, String reason, boolean success) {
        this.user = user;
        this.reason = reason;
        this.success = success;
    }

    public INFOResponsePacket(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public Byte getCommand() {
        return PacketCommand.INFOResponse;
    }
}
