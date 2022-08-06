package me.youm.client.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.client.init.ChatClient;
import me.youm.message.BanUserResponsePacket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author : You_M
 * @date : 2022/8/5 17:14 32
 * @projectName : KES-IRC-Server
 * @className : BanUserResponseHandler
 */
@ChannelHandler.Sharable
public class BanUserResponseHandler extends SimpleChannelInboundHandler<BanUserResponsePacket> {
    private static final Logger log = LogManager.getLogger(ChatClient.class);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, BanUserResponsePacket banUserResponsePacket) throws Exception {
        log.info("{} | {}" ,banUserResponsePacket.isSuccess(), banUserResponsePacket.getReason());
    }
}
