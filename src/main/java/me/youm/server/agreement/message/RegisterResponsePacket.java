package me.youm.server.agreement.message;

public class RegisterResponsePacket extends Packet {
    private boolean success;
    private String reason;
    private String userName;
    private String passWord;
    private String nickName;

    public RegisterResponsePacket() {
    }
    public RegisterResponsePacket(boolean success, String reason) {
        this.success = success;
        this.reason = reason;
    }
    public RegisterResponsePacket(boolean success, String reason, String userName, String passWord, String nickName) {
        this.success = success;
        this.reason = reason;
        this.userName = userName;
        this.passWord = passWord;
        this.nickName = nickName;
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
        return PacketCommand.LoginResponse;
    }
}
