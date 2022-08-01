package me.youm.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.server.agreement.message.LoginResponsePacket;

public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LoginResponsePacket loginResponseMessage) throws Exception {
        System.out.println(loginResponseMessage.isSuccess() +" | " + loginResponseMessage.getReason());
    }
}
