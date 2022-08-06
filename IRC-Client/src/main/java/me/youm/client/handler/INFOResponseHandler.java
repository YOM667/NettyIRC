package me.youm.client.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.client.init.ChatClient;
import me.youm.message.INFOResponsePacket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author : You_M
 * @date : 2022/8/3 11:38 12
 * @projectName : KES-IRC-Server
 * @className : INFOResponseHandler
 */
@ChannelHandler.Sharable
public class INFOResponseHandler extends SimpleChannelInboundHandler<INFOResponsePacket> {
    private static final Logger log = LogManager.getLogger(ChatClient.class);
    /**
     * 读取INFOResponsePacket数据包的方法
     * @param channelHandlerContext ChannelHandlerContext对象
     * @param infoResponsePacket  INFOResponsePacket数据包
     * @throws Exception 异常
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, INFOResponsePacket infoResponsePacket) throws Exception {
        log.info( "{} | {} | {}",infoResponsePacket.getUser().toString() , infoResponsePacket.getReason() , infoResponsePacket.isSuccess());
    }
}
