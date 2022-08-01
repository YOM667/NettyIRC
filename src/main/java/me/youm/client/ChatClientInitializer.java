package me.youm.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import me.youm.client.handler.LoginResponseHandler;
import me.youm.client.handler.ReadHandler;
import me.youm.client.handler.RegisterResponseHandler;
import me.youm.server.codec.IRCMessageCodec;
import me.youm.server.protocol.ProcotolFrameDecoder;

public class ChatClientInitializer extends ChannelInitializer<SocketChannel> {
    private final RegisterResponseHandler REGISTER_HANDLER = new RegisterResponseHandler();
    private final LoginResponseHandler LOGIN_HANDLER = new LoginResponseHandler();
    @Override
    protected void initChannel(SocketChannel socketChannel) {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new ProcotolFrameDecoder());
        // pipeline.addLast(new StringDecoder());
        // pipeline.addLast(new StringEncoder());
        pipeline.addLast(new IRCMessageCodec());
        pipeline.addLast(new ReadHandler());
        pipeline.addLast(REGISTER_HANDLER);
        pipeline.addLast(LOGIN_HANDLER);
    }
}
