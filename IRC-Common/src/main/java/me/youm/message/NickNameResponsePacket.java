package me.youm.message;

public class NickNameResponsePacket extends Packet{
    private String reason;
    private boolean isSuccess;


    public NickNameResponsePacket( boolean isSuccess,String reason) {
        this.reason = reason;
        this.isSuccess = isSuccess;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    @Override
    public Byte getCommand() {
        return PacketCommand.NickNameResponse;
    }
}
