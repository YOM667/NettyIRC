package me.youm.message;

/**
 * @author : You_M
 * @date : 2022/8/5 16:59 02
 * @projectName : KES-IRC-Server
 * @className : BanUserResponsePacket
 */
public class BanUserResponsePacket extends Packet{
    private boolean isSuccess;
    private String reason;

    public BanUserResponsePacket() {
    }

    public BanUserResponsePacket(boolean isSuccess, String reason) {
        this.isSuccess = isSuccess;
        this.reason = reason;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public Byte getCommand() {
        return PacketCommand.BanUserResponse;
    }
}
