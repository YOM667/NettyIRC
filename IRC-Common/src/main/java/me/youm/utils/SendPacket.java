package me.youm.utils;

import io.netty.channel.ChannelHandlerContext;
import me.youm.message.Packet;

/**
 * @author : You_M
 * @date : 2022/8/3 11:56 37
 * @projectName : KES-IRC-Server
 * @className : SendPacket
 */
public class SendPacket {
    public static void sendPacketToServer(ChannelHandlerContext channel, Packet packet){
        channel.writeAndFlush(packet);
    }
}
