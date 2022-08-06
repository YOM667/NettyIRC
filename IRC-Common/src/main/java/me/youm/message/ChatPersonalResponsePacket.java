package me.youm.message;

import io.netty.channel.Channel;
import me.youm.entity.Message;
import me.youm.entity.User;

/**
 * @author : You_M
 * @date : 2022/8/6 11:40 23
 * @projectName : KES-IRC-Server
 * @className : ChatPersonalResponsePacket
 */
public class ChatPersonalResponsePacket extends Packet{
    private Message message;
    private boolean isSuccess;
    private String reason;

    public ChatPersonalResponsePacket() {
    }
    public ChatPersonalResponsePacket( Message message, boolean isSuccess, String reason) {
        this.message = message;
        this.isSuccess = isSuccess;
        this.reason = reason;
    }
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
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
        return PacketCommand.ChatPersonalResponse;
    }
}
