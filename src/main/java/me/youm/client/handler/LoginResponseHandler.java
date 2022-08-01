package me.youm.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.server.message.LoginResponseMessage;

public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponseMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LoginResponseMessage loginResponseMessage) throws Exception {
        System.out.println(loginResponseMessage.isSuccess() +" | " + loginResponseMessage.getCommand());
    }
}
