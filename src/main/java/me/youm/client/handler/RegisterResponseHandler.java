package me.youm.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.server.protocol.message.RegisterResponseMessage;

public class RegisterResponseHandler extends SimpleChannelInboundHandler<RegisterResponseMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RegisterResponseMessage registerResponseMessage) throws Exception {
        System.out.println(registerResponseMessage.getUserName() + " | " + registerResponseMessage.getPassWord() + " | " + registerResponseMessage.getNickName() + " | " + registerResponseMessage.isSuccess() + " | " + registerResponseMessage.getCommand());
    }
}
