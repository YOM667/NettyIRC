package me.youm.server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.entity.Message;
import me.youm.message.ChatPersonalRequestPacket;
import me.youm.message.ChatPersonalResponsePacket;
import me.youm.session.Session;
import me.youm.session.SessionFactory;
import me.youm.utils.SendPacket;

/**
 * @author : You_M
 * @date : 2022/8/6 11:47 57
 * @projectName : KES-IRC-Server
 * @className : ChatPersonalHandler
 */
@ChannelHandler.Sharable
public class ChatPersonalHandler extends SimpleChannelInboundHandler<ChatPersonalRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ChatPersonalRequestPacket chatPersonalRequestPacket) throws Exception {
        String to = chatPersonalRequestPacket.getUsername();
        Message message = chatPersonalRequestPacket.getMessage();
        Channel channel = SessionFactory.getSession().getChannel(to);
        if (channel != null && message != null) {
            ChatPersonalResponsePacket packet = new ChatPersonalResponsePacket(message, true, "发送成功");
            channel.writeAndFlush(packet);
            SendPacket.sendPacketToServer(channelHandlerContext,packet);
        }else {
            SendPacket.sendPacketToServer(channelHandlerContext,new ChatPersonalResponsePacket(message,false,"无法向"+to+"发送消息,请检查"));
        }
    }
}
