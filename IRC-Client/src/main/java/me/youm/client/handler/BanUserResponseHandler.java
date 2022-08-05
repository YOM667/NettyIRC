package me.youm.client.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.message.BanUserResponsePacket;

/**
 * @author : You_M
 * @date : 2022/8/5 17:14 32
 * @projectName : KES-IRC-Server
 * @className : BanUserResponseHandler
 */
@ChannelHandler.Sharable
public class BanUserResponseHandler extends SimpleChannelInboundHandler<BanUserResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, BanUserResponsePacket banUserResponsePacket) throws Exception {
        System.out.println(banUserResponsePacket.isSuccess() + " | " + banUserResponsePacket.getReason());
    }
}
