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
    /**
     * 读取INFOResponsePacket数据包的方法
     * @param channelHandlerContext ChannelHandlerContext对象
     * @param infoResponsePacket  INFOResponsePacket数据包
     * @throws Exception 异常
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, INFOResponsePacket infoResponsePacket) throws Exception {
        System.out.println(infoResponsePacket.getUser().toString() + " | " + infoResponsePacket.getReason() + " | " + infoResponsePacket.isSuccess());
    }
}
