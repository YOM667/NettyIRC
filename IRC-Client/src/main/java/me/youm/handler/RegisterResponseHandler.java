package me.youm.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.message.RegisterResponsePacket;
/**
 * @author : You_M
 * @date : 2022/8/2 14:54 25
 * @projectName : KES-IRC-Server
 * @className : RegisterResponseHandler
 */

public class RegisterResponseHandler extends SimpleChannelInboundHandler<RegisterResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RegisterResponsePacket packet) throws Exception {
        System.out.println(packet.getUserName() + " | " + packet.getPassWord() + " | " + packet.getNickName() + " | " + packet.isSuccess() + " | " + packet.getReason());
    }
}
