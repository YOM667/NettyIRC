package me.youm.message;

import me.youm.entity.Message;

/**
 * @author : You_M
 * @date : 2022/8/3 12:20 35
 * @projectName : KES-IRC-Server
 * @className : ChatGroupResponsePacket
 */
public class ChatGroupResponsePacket extends Packet{

    public String message;

    public ChatGroupResponsePacket() {
    }

    public ChatGroupResponsePacket(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return PacketCommand.ChatGroupResponse;
    }
}
