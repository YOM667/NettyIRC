package me.youm.server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
@ChannelHandler.Sharable
public class ChatGroupHandler extends SimpleChannelInboundHandler<String> {
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx)  {
        Channel inComing = ctx.channel();
        channels.add(inComing);
        for (Channel c : channels) {
            if(c!=inComing){
                c.writeAndFlush("[欢迎:]  "+inComing.remoteAddress()+"  进入聊天室" + "\n");
            }
        }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel outComing = ctx.channel();
        channels.remove(outComing);
        for (Channel c : channels) {
            if(c!=outComing){
                c.writeAndFlush("[拜拜:]  "+outComing.remoteAddress()+"  离开聊天室" + "\n");
            }
        }
        super.handlerRemoved(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx)  {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + "  在线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + "  离线");
        super.channelInactive(ctx);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) {
        Channel channel = channelHandlerContext.channel();

        for (Channel c : channels) {
            System.out.println("[用户  " + channel.remoteAddress() + "  说:]  " + s + "\n");

            if (c != channel) {
                c.writeAndFlush("[用户  " + channel.remoteAddress() + "  说:]  " + s + "\n");
            } else {
                c.writeAndFlush("[我  " + channel.remoteAddress() + "  说:]  " + s + "\n");

            }
        }
    }

}
