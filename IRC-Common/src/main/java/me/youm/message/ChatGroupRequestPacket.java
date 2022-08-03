package me.youm.message;

import me.youm.entity.Message;

/**
 * @author : You_M
 * @date : 2022/8/3 12:19 03
 * @projectName : KES-IRC-Server
 * @className : ChatGroupRequestPacket
 */
public class ChatGroupRequestPacket extends Packet{
    public Message message;

    public ChatGroupRequestPacket() {
    }

    public ChatGroupRequestPacket(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
    @Override
    public Byte getCommand() {
        return PacketCommand.ChatGroupRequest;
    }
}
