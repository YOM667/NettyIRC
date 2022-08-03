package me.youm.client.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.message.RegisterResponsePacket;
/**
 * @author : You_M
 * @date : 2022/8/2 14:54 25
 * @projectName : KES-IRC-Server
 * @className : RegisterResponseHandler
 */
@ChannelHandler.Sharable
public class RegisterResponseHandler extends SimpleChannelInboundHandler<RegisterResponsePacket> {
    /**
     * 读取RegisterResponsePacket数据包的方法
     * @param channelHandlerContext ChannelHandlerContext对象
     * @param packet  RegisterResponsePacket数据包
     * @throws Exception 异常
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RegisterResponsePacket packet) throws Exception {
        System.out.println(packet.getUserName() + " | " + packet.getPassWord() + " | " + packet.getNickName() + " | " + packet.isSuccess() + " | " + packet.getReason());
    }
}
