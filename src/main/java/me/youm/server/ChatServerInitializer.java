package me.youm.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import me.youm.client.handler.RegisterResponseHandler;
import me.youm.server.codec.IRCMessageCodec;
import me.youm.server.handler.ChatGroupHandler;
import me.youm.server.handler.LoginRequestHandler;
import me.youm.server.protocol.ProcotolFrameDecoder;

public class ChatServerInitializer extends ChannelInitializer<SocketChannel> {
    private final LoginRequestHandler LOGIN_HANDLER = new LoginRequestHandler();
    private final RegisterResponseHandler REGISTER_HANDLER = new RegisterResponseHandler();
    @Override
    protected void initChannel(SocketChannel socketChannel)  {
        System.out.println("有客户端进入: "+socketChannel.remoteAddress());
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new ProcotolFrameDecoder());
        //        pipeline.addLast(new StringDecoder());
//        pipeline.addLast(new StringEncoder());
        pipeline.addLast(new IRCMessageCodec());
        pipeline.addLast(new ChatGroupHandler());
        pipeline.addLast(LOGIN_HANDLER);
        pipeline.addLast(REGISTER_HANDLER);
    }
}
