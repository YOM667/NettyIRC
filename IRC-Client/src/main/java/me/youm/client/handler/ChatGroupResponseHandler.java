package me.youm.client.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.message.ChatGroupRequestPacket;
import me.youm.message.ChatGroupResponsePacket;

/**
 * @author : You_M
 * @date : 2022/8/3 12:28 36
 * @projectName : KES-IRC-Server
 * @className : ChatGroupResponseHandler
 */
@ChannelHandler.Sharable
public class ChatGroupResponseHandler extends SimpleChannelInboundHandler<ChatGroupResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ChatGroupResponsePacket chatGroupResponsePacket) throws Exception {
        System.out.println(chatGroupResponsePacket.getMessage());
    }
}
