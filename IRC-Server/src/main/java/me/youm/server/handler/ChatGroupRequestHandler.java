package me.youm.server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import me.youm.message.ChatGroupRequestPacket;
import me.youm.message.ChatGroupResponsePacket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ChannelHandler.Sharable
public class ChatGroupRequestHandler extends SimpleChannelInboundHandler<ChatGroupRequestPacket> {
    public static final Logger log = LogManager.getLogger(ChatGroupRequestHandler.class);
    @Override
    public void handlerAdded(ChannelHandlerContext ctx)  {
        Channel inComing = ctx.channel();
        channels.add(inComing);
        for (Channel c : channels) {
            if(c!=inComing){
                c.writeAndFlush(new ChatGroupResponsePacket("<服务器>  [欢迎:]  "+inComing.remoteAddress()+"  进入聊天室" + "\n"));
            }
        }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel outComing = ctx.channel();
        channels.remove(outComing);
        for (Channel c : channels) {
            if(c!=outComing){
                c.writeAndFlush(new ChatGroupResponsePacket("<服务器>  [拜拜:]  "+outComing.remoteAddress()+"  离开聊天室" + "\n"));
            }
        }
        super.handlerRemoved(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx)  {
        Channel channel = ctx.channel();
        log.info("{}  在线",channel.remoteAddress());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        log.info( "{}  离线",channel.remoteAddress());
    }
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ChatGroupRequestPacket s) {
        Channel channel = channelHandlerContext.channel();
        log.info("[用户  {}  说:]  {}",s.getMessage().getUser().getNickName(), s.getMessage().getMessage());
        for (Channel c : channels) {
            if (c != channel) {
                c.writeAndFlush(new ChatGroupResponsePacket("[用户  " + s.getMessage().getUser().getNickName() + "  说:]  " + s.getMessage().getMessage() ));
            } else {
                c.writeAndFlush(new ChatGroupResponsePacket("[我 说:]  " + s.getMessage().getMessage() ));
            }
        }
    }

}
