package me.youm.server.agreement.message;

public class LoginResponsePacket extends Packet {
    private boolean success;
    private String reason;

    public LoginResponsePacket() {
    }

    public LoginResponsePacket(boolean success, String reason) {
        this.success = success;
        this.reason = reason;
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

    @Override
    public Byte getCommand() {
        return PacketCommand.LoginResponse;
    }
}
