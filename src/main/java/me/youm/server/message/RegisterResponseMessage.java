package me.youm.server.message;

public class RegisterResponseMessage extends Packet {
    private boolean success;
    private String reason;
    private String userName;
    private String passWord;
    private String nickName;

    public RegisterResponseMessage() {
    }
    public RegisterResponseMessage(boolean success, String reason) {
        this.success = success;
        this.reason = reason;
    }
    public RegisterResponseMessage(boolean success, String reason, String userName, String passWord, String nickName) {
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

    public String getType() {
        return reason;
    }

    public void setType(String reason) {
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
