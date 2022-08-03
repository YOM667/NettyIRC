package me.youm.client.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.message.NickNameResponsePacket;
/**
 * @author : You_M
 * @date : 2022/8/2 14:54 25
 * @projectName : KES-IRC-Server
 * @className : NickNameResponseHandler
 */
@ChannelHandler.Sharable
public class NickNameResponseHandler extends SimpleChannelInboundHandler<NickNameResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, NickNameResponsePacket nickNameResponsePacket) throws Exception {
        System.out.println(nickNameResponsePacket.isSuccess() +" | " + nickNameResponsePacket.getReason() );
    }
}
