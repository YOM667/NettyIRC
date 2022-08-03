package me.youm.message;

import me.youm.entity.User;

public class LoginResponsePacket extends Packet {
    private boolean success;
    private String reason;
    private User user;
    public LoginResponsePacket(boolean success, String reason,User user) {
        this.success = success;
        this.reason = reason;
        this.user = user;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public Byte getCommand() {
        return PacketCommand.LoginResponse;
    }
}
