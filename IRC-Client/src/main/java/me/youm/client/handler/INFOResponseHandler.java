package me.youm.client.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.message.INFOResponsePacket;

/**
 * @author : You_M
 * @date : 2022/8/3 11:38 12
 * @projectName : KES-IRC-Server
 * @className : INFOResponseHandler
 */
@ChannelHandler.Sharable
public class INFOResponseHandler extends SimpleChannelInboundHandler<INFOResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, INFOResponsePacket infoResponsePacket) throws Exception {
        System.out.println(infoResponsePacket.getUser().toString() + " | " + infoResponsePacket.getReason() + " | " + infoResponsePacket.isSuccess());
    }
}
