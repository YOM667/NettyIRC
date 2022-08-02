package me.youm.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.message.NickNameResponsePacket;

public class NickNameResponseHandler extends SimpleChannelInboundHandler<NickNameResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, NickNameResponsePacket nickNameResponsePacket) throws Exception {
        System.out.println(nickNameResponsePacket.isSuccess() +" | " + nickNameResponsePacket.getReason() );
    }
}
