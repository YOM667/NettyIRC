package me.youm.client.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
/**
 * @author : You_M
 * @date : 2022/8/2 14:54 25
 * @projectName : KES-IRC-Server
 * @className : ReadHandler
 */
@ChannelHandler.Sharable
public class ReadHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)  {
        System.out.println(msg);
    }
}
