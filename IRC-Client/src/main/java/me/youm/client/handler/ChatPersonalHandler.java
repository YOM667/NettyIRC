package me.youm.client.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.client.init.ChatClient;
import me.youm.entity.Message;
import me.youm.message.ChatPersonalResponsePacket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

/**
 * @author : You_M
 * @date : 2022/8/6 11:59 41
 * @projectName : KES-IRC-Server
 * @className : ChatPersonalHandler
 */
@ChannelHandler.Sharable
public class ChatPersonalHandler extends SimpleChannelInboundHandler<ChatPersonalResponsePacket> {
    private static final Logger log = LogManager.getLogger(ChatClient.class);
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ChatPersonalResponsePacket chatPersonalResponsePacket) throws Exception {
        Message message = chatPersonalResponsePacket.getMessage();
        ChatClient chatClient = ChatClient.getChatClient();
        if (chatPersonalResponsePacket.isSuccess() && !(message.getUser().equals(chatClient.getUser()))) {
            log.info("[ {} ] 私发给你了一条消息内容是: {}",message.getUser().getNickName() , message.getMessage());
        } else if (message.getUser().equals(chatClient.getUser()) && chatPersonalResponsePacket.isSuccess()) {
            log.info("{} | {}" ,chatPersonalResponsePacket.isSuccess(), chatPersonalResponsePacket.getReason());
        }else {
            log.info("{} | {}" ,chatPersonalResponsePacket.isSuccess(), chatPersonalResponsePacket.getReason());
        }
    }
}
