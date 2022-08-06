package me.youm.client.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.client.init.ChatClient;
import me.youm.entity.Message;
import me.youm.message.ChatPersonalResponsePacket;

import java.util.Objects;

/**
 * @author : You_M
 * @date : 2022/8/6 11:59 41
 * @projectName : KES-IRC-Server
 * @className : ChatPersonalHandler
 */
@ChannelHandler.Sharable
public class ChatPersonalHandler extends SimpleChannelInboundHandler<ChatPersonalResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ChatPersonalResponsePacket chatPersonalResponsePacket) throws Exception {
        Message message = chatPersonalResponsePacket.getMessage();
        ChatClient chatClient = ChatClient.getChatClient();
        if (chatPersonalResponsePacket.isSuccess() && !(message.getUser().equals(chatClient.getUser()))) {
            System.out.println("[ " + message.getUser().getNickName() + " ] 私发给你了一条消息内容是:" + message.getMessage());
        } else if (message.getUser().equals(chatClient.getUser()) && chatPersonalResponsePacket.isSuccess()) {
            System.out.println(chatPersonalResponsePacket.isSuccess() + " | " + chatPersonalResponsePacket.getReason());
        }else {
            System.out.println(chatPersonalResponsePacket.isSuccess() + " | " + chatPersonalResponsePacket.getReason());
        }
    }
}
